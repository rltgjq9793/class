package answer;

import com.google.gson.Gson;
import domain.Movie;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class DataServer {

    //bad code
    public static void main(String[] args) throws Exception{

        ServerSocket serverSocket = new ServerSocket(7777);

        System.out.println("READY");

        Socket socket = serverSocket.accept();
        OutputStream out = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(out);

        ArrayList<Movie> movieArrayList = new ArrayList<>();
        for(int i = 0; i < 10; i++){

            Movie movie = new Movie();
            movie.setTitle("다크 나이트" + i);
            movie.setDirector("크리스토퍼 놀란");
            movie.setPop(1300);
            movie.setScore(4.7);
            movieArrayList.add(movie);
        }

        Gson gson = new Gson();
        String str = gson.toJson(movieArrayList);
        dos.writeUTF(str);


        dos.close();
        socket.close();
        serverSocket.close();

    }
}
