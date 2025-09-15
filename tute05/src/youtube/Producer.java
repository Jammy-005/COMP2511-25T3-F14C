package youtube;

import java.util.ArrayList;
import java.util.List;

public class Producer {
    private String name;
    private List<Video> videos = new ArrayList<Video>();

    public Producer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
