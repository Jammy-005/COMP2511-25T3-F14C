package youtube;

import java.util.ArrayList;
import java.util.List;

public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public void subscribeTo(Producer user) {
        user.addSubscriber(this);
    }

    public void alertNewVideo(Video video) {
        System.out.println(name + ": A new video " + video.getName() + " was just posted from "
                + video.getProducer() + "!");
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Subject s) {
        if (s.getClass().equals(Producer.class)) {
            updateProducer((Producer) s);
        }
    }

    public void updateProducer(Producer producer) {
        alertNewVideo(producer.getLatestVideo());
    }

    public static void main(String[] args) {
        Producer producer = new Producer("Rock");
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            Producer user = new Producer(Integer.toString(i));
            users.add(user);
            producer.addSubscriber(user);
        }

        producer.postVideo("Video1", 20);
    }
}
