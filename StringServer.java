import java.io.IOException;
import java.net.URI;


class Handler implements URLHandler {
    String s = "";
    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
            return String.format(s);
        }
        else if (url.getPath().contains("/add-message")) {
            String[] message = url.getQuery().split("=");
            if(message[0].equals("s")){
                s += message[1] + "\n";
                return String.format(s);
            }  
        }
        return "404 Not Found!";
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}