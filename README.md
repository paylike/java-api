# A minimalist paylike JAVA API client

This is a minimal implementation of the paylike API in Java.

This does not try to do anything fancy, it is just a thin wrapper around HTTP calls that serializes data directly to Java Objects.

As per java convention, library performs synchronious calls only. But can be wrapped in your favorite async/future call library very easily.

This library does not implement the full API, but may be extended in the future to support more.

# Example usage

    final String apiKey = " ... ";

    // Make sure to use this key onwards
    final String authorizationHeader = Paylike.authHeaderFromApiKey(apiKey);

    Identity app = Paylike.currentApp(authorizationHeader);
    System.out.println(app); => Identity{id='...', name='...', created='2016-11-22T16:29:20.955Z'}

    List<Merchant> merchants = Paylike.fetchAllMerchants(authorizationHeader, app.id, 50, null, null);
    System.out.println(merchants); // => [Merchant{tds=Tds{mode='avoid'}, pricing=Pricing{rate=0.025, dispute=Charge{currency='EUR', amount=3500},
                                  // flat=Charge{currency='EUR', amount=25}}, bank=Bank{}, balance=0, claim=Claim{canSaveCard=true, canChargeCard=true, canVoid=true, canRefund=true,
                                  // canCapture=true}, company=Company{country='Denmark', number='...'}, email='...', website='...', descriptor='A test descriptor',
                                  // key='...', test=true, currency='DKK', name='...', created='2016-11-22T16:29:15.783Z',
                                  // id='...'}]

    Merchant mainMerchant = merchants.get(0);

    List<Transaction> transactions = Paylike.fetchAllTransactions(authorizationHeader, mainMerchant.id, 50, null, null);


    Transaction transactionToRepeat = transactions.get(0);

    Map custom = new HashMap<>();
    custom.put("hi", "foo");

    String newTransactionId =
    Paylike.createTransactionFromPreviousTransaction(authorizationHeader, mainMerchant.id,
      new CreateTransactionFromPreviusTransactionData( 100, transactionToRepeat.id, "test-descriptor", "DKK", custom ));

    Transaction createdTransaction = Paylike.fetchTransaction(authorizationHeader, newTransactionId);
    System.out.println(createdTransaction); // Transaction{id='...', test=true, merchantId='...',
                                            // created='2016-11-22T16:33:35.307Z', amount=100, refundedAmount=0, capturedAmount=0, voidedAmount=0,
                                            // pendingAmount=100, disputedAmount=0, card=Card{bin='410000', last4='0000', expiry='2024-09-30T21:59:59.999Z',
                                            // scheme='visa'}, tds=false, currency='DKK', custom={hi=foo}, recurring=true, successful=true, error=false,
                                            // descriptor='...', trail=[]}

    Paylike.voidTransaction(authorizationHeader, createdTransaction.id, new VoidData(100));

# API overview

    CreateAppResponse createApp(String name) throws IOException, PaylikeException

    Identity currentApp(String base64EncodedAuthorization) throws IOException, PaylikeException

    CreateMerchantResponse createMerchant(String base64EncodedAuthorization, MerchantData merchantDefinition) throws IOException, PaylikeException

    void updateMerchant(String base64EncodedAuthorization, String merchantId, UpdateMerchantData updateMerchantDefinition) throws IOException, PaylikeException

    List<Merchant> fetchAllMerchants(String base64EncodedAuthorization, String appId, int limit, String before, String after) throws IOException, PaylikeException<Merchant>

    Merchant fetchMerchant(String base64EncodedAuthorization, String merchantId) throws IOException, PaylikeException

    InviteUserResponse inviteUser(String base64EncodedAuthorization, String merchantId, InviteUserData invitationData) throws IOException, PaylikeException

    void revokeUser(String base64EncodedAuthorization, String merchantId, String userId) throws IOException, PaylikeException

    List<User> fetchAllUsers(String base64EncodedAuthorization, String merchantId, int limit, String before, String after) throws IOException, PaylikeException<User>

    void addApp(String base64EncodedAuthorization, String merchantId, String appId) throws IOException, PaylikeException

    void revokeApp(String base64EncodedAuthorization, String merchantId, String appId) throws IOException, PaylikeException

    List<Line> fetchAllMerchantLines(String base64EncodedAuthorization, String merchantId, int limit, String before, String after) throws IOException, PaylikeException<Line>

    // Returns transaction ID
    String createTransactionFromPreviousTransaction(String base64EncodedAuthorization, String merchantId, CreateTransactionFromPreviusTransactionData data) throws IOException, PaylikeException

    // Returns transaction ID
    String createFromSavedCard(String base64EncodedAuthorization, String merchantId, String cardId, String currency, String descriptor, int amount, Map custom) throws IOException, PaylikeException

    Transaction refundTransaction(String base64EncodedAuthorization, String transactionId, RefundData data) throws IOException, PaylikeException

    Transaction voidTransaction(String base64EncodedAuthorization, String transactionId, VoidData data) throws IOException, PaylikeException

    List<Transaction> fetchAllTransactions(String base64EncodedAuthorization, String merchantId, int limit, String before, String after) throws IOException, PaylikeException<Transaction>

    Transaction fetchTransaction(String base64EncodedAuthorization, String transactionId) throws IOException, PaylikeException

    CardWithId saveCard(String base64EncodedAuthorization, String merchantId, String transactionId, String notes) throws IOException, PaylikeException

    Transaction captureTransaction(String base64EncodedAuthorization, String transactionId, long amount, String currency, String descriptor) throws IOException, PaylikeException

# Maven

We do not have a maven group-id yet, so you have to add our repo if you want to use this as a maven dependency.
So you need to include the following in your pom file to use the library:

First, add this repository in the repositories:

    <repositories>
        <repository>
            <id>paylike-mvn-repo</id>
            <url>https://raw.github.com/paylike/java-api/mvn-repo/</url>
        </repository>
        ...

Then just add paylike as a dependency

    <dependency>
        <groupId>com.paylike</groupId>
        <artifactId>paylike</artifactId>
        <version>0.9.1</version>
    </dependency>

Version `0.9.1` is the latest (and only) at the moment.

# Dependencies

This project only depends on Gson to perform the deserialization/serialization between JSON and Java objects.

# Licence

Copyright (c) 2016 mineisyours AS

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.