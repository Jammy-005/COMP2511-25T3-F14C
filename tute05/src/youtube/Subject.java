package youtube;

public interface Subject {
    public void notifySubscribers();
    public void addSubscriber(Observer o);
    public void removeSubscriber(Observer o);
}
