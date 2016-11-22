package com.paylike;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.paylike.exceptions.PaylikeException;
import com.paylike.models.*;
import com.paylike.models.requests.*;
import com.paylike.models.responses.*;

import java.io.IOException;
import java.util.*;

/**
 * Created by jankjr on 17/11/2016.
 */
public class Paylike {
  public static String apiBase = "https://api.paylike.io/";

  public static<T> List<T> jsonArrayToTypedList(Class<T> cls, JsonArray arr){
    Gson g = new Gson();
    ArrayList<T> result = new ArrayList<T>();
    for(JsonElement elemen : arr){
      result.add(g.fromJson(elemen, cls));
    }
    return result;
  }

  public static String pagination(int limit, String before, String after){
    if(before == null && after == null){
      return String.format("limit=%s", limit);
    }
    if(after == null){
      return String.format("limit=%s&before=%s", limit, before);
    }
    return String.format("limit=%s&before=%s&after=%s", limit, before, after);
  }
  public static String authHeaderFromApiKey(String apiKey){
    return "Basic " + new String(Base64.getEncoder().encode((":" + apiKey).getBytes()));
  }

  public static String path(String path, Object ... args){
    return String.format("%s%s", apiBase, String.format(path, args));
  }

  public static CreateAppResponse createApp(String name) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(CreateAppResponse.class, "POST", path("apps"), new CreateAppData(name), null);
  }

  public static Identity currentApp(String authHeader) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(CurrentAppResponse.class, "GET", path("me"), null, authHeader).identity;
  }

  public static CreateMerchantResponse createMerchant(String authHeader, MerchantData merchantDefinition) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(CreateMerchantResponse.class, "POST", path("merchants"), merchantDefinition, authHeader);
  }

  public static void updateMerchant(String authHeader, String merchantId, UpdateMerchantData updateMerchantDefinition) throws IOException, PaylikeException {
    MinimalistPaylikeClient.call(Void.class, "PUT", path("merchants/%s", merchantId), updateMerchantDefinition, authHeader);
  }

  public static List<Merchant> fetchAllMerchants(String authHeader, String appId, int limit, String before, String after) throws IOException, PaylikeException {
    JsonArray res = MinimalistPaylikeClient.call(JsonArray.class, "GET", path("identities/%s/merchants?%s", appId, pagination(limit, before, after)), null, authHeader);
    return jsonArrayToTypedList(Merchant.class, res);
  }

  public static Merchant fetchMerchant(String authHeader, String merchantId) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(Merchant.class, "GET", path("merchants/%s", merchantId), null, authHeader);
  }

  public static InviteUserResponse inviteUser(String authHeader, String merchantId, InviteUserData invitationData) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(InviteUserResponse.class, "POST", path("merchants/%s/users", merchantId), invitationData, authHeader);
  }

  public static void revokeUser(String authHeader, String merchantId, String userId) throws IOException, PaylikeException {
    MinimalistPaylikeClient.call(Void.class, "DELETE", path("merchants/%s/users/%s", merchantId, userId), null, authHeader);
  }

  public static List<User> fetchAllUsers(String authHeader, String merchantId, int limit, String before, String after) throws IOException, PaylikeException {
    JsonArray arr = MinimalistPaylikeClient.call(JsonArray.class, "GET", path("merchants/%s/users?%s", merchantId, pagination(limit, before, after)), null, authHeader);
    return jsonArrayToTypedList(User.class, arr);
  }
  public static void addApp(String authHeader, String merchantId, String appId) throws IOException, PaylikeException {
    MinimalistPaylikeClient.call(Void.class, "POST", path("merchants/%s/apps", merchantId), new AddAppData(appId), authHeader);
  }

  public static void revokeApp(String authHeader, String merchantId, String appId) throws IOException, PaylikeException {
    MinimalistPaylikeClient.call(Void.class, "DELETE", path("merchants/%s/apps/%s", merchantId, appId), null, authHeader);
  }

  public static List<Line> fetchAllMerchantLines(String authHeader, String merchantId, int limit, String before, String after) throws IOException, PaylikeException {
    JsonArray arr = MinimalistPaylikeClient.call(JsonArray.class, "GET", path("merchants/%s/lines?%s", merchantId, pagination(limit, before, after)), null, authHeader);
    return jsonArrayToTypedList(Line.class, arr);
  }

  public static String createTransactionFromPreviousTransaction(String authHeader, String merchantId, CreateTransactionFromPreviusTransactionData data) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(TransactionResponse.class, "POST", path("merchants/%s/transactions", merchantId), data, authHeader).transaction.id;
  }

  public static String createFromSavedCard(String authHeader, String merchantId, String cardId, String currency, String descriptor, int amount, Map custom) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(TransactionResponse.class, "POST", path("merchants/%s/transactions", merchantId), new CreateTransactionFromSavedCardInput(cardId, currency, descriptor, amount, custom), authHeader).transaction.id;
  }

  public static Transaction refundTransaction(String authHeader, String transactionId, RefundData data) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(RefundResponse.class, "POST", path("transactions/%s/refunds", transactionId), data, authHeader).transaction;
  }

  public static Transaction voidTransaction(String authHeader, String transactionId, VoidData data) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(TransactionResponse.class, "POST", path("transactions/%s/voids", transactionId), data, authHeader).transaction;
  }

  public static List<Transaction> fetchAllTransactions(String authHeader, String merchantId, int limit, String before, String after) throws IOException, PaylikeException {
    JsonArray res = MinimalistPaylikeClient.call(JsonArray.class, "GET", path("merchants/%s/transactions?%s", merchantId, pagination(limit, before, after)), null, authHeader);
    return jsonArrayToTypedList(Transaction.class, res);
  }

  public static Transaction fetchTransaction(String authHeader, String transactionId) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(FetchTransactionResponse.class, "GET", path("transactions/%s", transactionId), null, authHeader).transaction;
  }

  public static CardWithId saveCard(String authHeader, String merchantId, String transactionId, String notes) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(SaveCardResponse.class, "POST", path("merchants/%s/cards", merchantId), new SaveCardData(transactionId, notes), authHeader).card;
  }

  public static Transaction captureTransaction(String authHeader, String transactionId, long amount, String currency, String descriptor) throws IOException, PaylikeException {
    return MinimalistPaylikeClient.call(TransactionResponse.class, "POST", path("transactions/%s/captures", transactionId), new CaptureTransactionData(amount, currency, descriptor), authHeader).transaction;
  }
}