package com.paylike;

import com.google.gson.Gson;
import com.paylike.exceptions.*;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by jankjr on 21/11/2016.
 */
class MinimalistPaylikeClient {
  public static <T, D> T call(Class<T> cls, String method, String url, D data, String base64EncodedApiKey) throws IOException, PaylikeException {
    Gson gson = new Gson();
    URL obj = new URL(url);
    HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

    con.setRequestMethod(method);
    con.setRequestProperty("Content-Type", "application/json");
    if(base64EncodedApiKey != null){
      con.setRequestProperty("authorization", base64EncodedApiKey);
    }

    if(data != null){
      String payload = gson.toJson(data);
      con.setDoOutput(true);
      DataOutputStream wr = new DataOutputStream(con.getOutputStream());
      wr.writeBytes(payload);
      wr.flush();
      wr.close();
    }

    int responseCode = con.getResponseCode();
    if(responseCode >= 400 && responseCode <= 500){
      if(responseCode == 401){
        throw new PaylikeUnauthorizedException(con.getResponseMessage(), responseCode);
      }
      if(responseCode == 403){
        throw new PaylikeForbiddenException(con.getResponseMessage(), responseCode);
      }
      if(responseCode == 409){
        throw new PaylikeConflictException(con.getResponseMessage(), responseCode);
      }
      throw new PaylikeException(con.getResponseMessage(), responseCode);
    }
    if(responseCode >= 500){
      throw new PaylikeServerError(con.getResponseMessage(), responseCode);
    }

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    if(cls.equals(Void.class)){
      return null;
    }

    return new Gson().fromJson(response.toString(), cls);
  }
}
