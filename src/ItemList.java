import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.common.http.Http;

public class ItemList implements Handler {
    private Clothing[] items;
     public ItemList(Clothing[] items) {
         this.items = items;
     }

     @Override
    public void accept(ServerRequest req, ServerResponse resp){
         resp.status(Http.Status.OK_200);
         resp.headers().put("Content-Type", "text/plain; charset=UTF-8");
         StringBuilder result = new StringBuilder();
         for (Clothing item : items) {
             result.append(item + "\n");
         }
         resp.send(result);
     }
}
