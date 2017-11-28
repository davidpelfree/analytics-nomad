package demo;

import com.hashicorp.nomad.apimodel.JobListStub;
import com.hashicorp.nomad.javasdk.JobsApi;
import com.hashicorp.nomad.javasdk.NomadApiClient;
import com.hashicorp.nomad.javasdk.NomadApiConfiguration;
import com.hashicorp.nomad.javasdk.ServerQueryResponse;

import java.util.List;

public class NomadMain {

    public static void main(String... args) throws Exception {

        final NomadApiConfiguration config = new NomadApiConfiguration.Builder()
                .setAddress("http://127.0.0.1:4646")
                .build();

        final NomadApiClient apiClient = new NomadApiClient(config);
        final JobsApi jobsApi = apiClient.getJobsApi();
        final ServerQueryResponse<List<JobListStub>> responseFuture = jobsApi.list();

        for (JobListStub job : responseFuture.getValue()) {
            System.out.println(job.getName());
        }

    }
}
