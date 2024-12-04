import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}

class ConcreteObserver implements Observer {
    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received update: " + message);
    }
}

public class Behavioral {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer obs1 = new ConcreteObserver("Observer 1");
        Observer obs2 = new ConcreteObserver("Observer 2");

        subject.addObserver(obs1);
        subject.addObserver(obs2);

        subject.setState("State Changed");
    }
}
