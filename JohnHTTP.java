import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JohnHTTP {
    private final HttpClient httpClient = HttpClient.newBuilder().version(HttpClient.Version.HTTP_2).build();
    private String link;

    public JohnHTTP(String l){
        link = l;
    }
    public void setLink(String l){
        link = l;
    }
    public String[] get(String[] headers){
        try {
            HttpRequest.Builder request = HttpRequest.newBuilder().GET().uri(URI.create(link));
            for (int i = 0; i < headers.length; i += 2) {
                request.header(headers[i], headers[i + 1]);
            }
            HttpRequest request2 = request.build();

            HttpResponse<String> response = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

            return new String[]{"" + response.statusCode(), response.body()};
        }catch(Exception e){
            System.out.println("Something went wrong. Unfortunately the developer is too lazy to add proper error handling so good luck!");
            e.printStackTrace();
            return new String[]{"-1", ""};
        }
    }

    public String[] Post(String[] headers, String p){
        try {
            HttpRequest.Builder request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(p)).uri(URI.create(link));
            for (int i = 0; i < headers.length; i += 2) {
                request.header(headers[i], headers[i + 1]);
            }
            HttpRequest request2 = request.build();

            HttpResponse<String> response = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

            return new String[]{"" + response.statusCode(), response.body()};
        }catch(Exception e){
            System.out.println("Something went wrong. Unfortunately the developer is too lazy to add proper error handling so good luck!");
            e.printStackTrace();
            return new String[]{"-1", ""};
        }
    }

    public String[] DELETE(String[] headers, String p) throws IllegalArgumentException{
        try {
            HttpRequest.Builder request = HttpRequest.newBuilder().DELETE()
                    .method("DELETE", HttpRequest.BodyPublishers.ofString(p))
                    .uri(URI.create(link));
            for (int i = 0; i < headers.length-1; i += 2) {
                request.header(headers[i], headers[i + 1]);
            }
            HttpRequest request2 = request.build();

            HttpResponse<String> response = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

            return new String[]{"" + response.statusCode(), response.body()};
        }catch(Exception e){
            System.out.println("Something went wrong. Unfortunately the developer is too lazy to add proper error handling so good luck!");
            e.printStackTrace();
            return new String[]{"-1", ""};
        }
    }



}
