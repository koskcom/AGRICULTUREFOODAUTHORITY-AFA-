package co.ke.bsl.network;

import co.ke.bsl.data.model.ClientInfo;
import co.ke.bsl.data.retrofit.ClientResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RecordsInterface {

    @POST("records/create")
    Call<ClientResponse> syncRecords(@Body ClientInfo clientInfo);

}
