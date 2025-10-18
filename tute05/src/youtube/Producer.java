package youtube;

import java.util.ArrayList;
import java.util.List;

public class Producer extends User implements Subject {
    private List<Video> videos = new ArrayList<Video>();
    private List<Observer> subscribers = new ArrayList<Observer>();

    public Producer(String name) {
        super(name);
    }

    public void postVideo(String name, int length) {
        Video video = new Video(name, length, this);
        videos.add(video);
        notifySubscribers();
    }

    public Video getLatestVideo() {
        return videos.get(videos.size() - 1);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void notifySubscribers() {
        subscribers.forEach(o -> o.update(this));
    }

    @Override
    public void addSubscriber(Observer o) {
        if (!subscribers.contains(o)) {
            subscribers.add(o);
        }
    }

    @Override
    public void removeSubscriber(Observer o) {
        subscribers.remove(o);
    }
}
