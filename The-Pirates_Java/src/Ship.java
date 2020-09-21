
class Ship implements Runnable {
    final private String name;
    final private int maxWeight;
    private int currentWeight;
    final private int maxSpeed;
    private int cruiseSpeed;
    private int x;
    private int y;
    private String destination;
    private int order_id;
    private boolean in_harbor;
    private String harborName;
    public int pathNumber;
    private Thread t;

    public Ship(String _name, int _maxWeight, int _currentWeight, int _maxSpeed, int _cruiseSpeed, int _x, int _y,
            String _destination, int _order_id, boolean _in_harbor, String _harborName, int _pathNumber) {
        this.name = _name;
        this.maxWeight = _maxWeight;
        this.currentWeight = _currentWeight;
        this.maxSpeed = _maxSpeed;
        this.cruiseSpeed = _cruiseSpeed;
        this.x = _x;
        this.y = _y;
        this.destination = _destination;
        this.order_id = _order_id;
        this.in_harbor = _in_harbor;
        this.harborName = _harborName;
        this.pathNumber = _pathNumber;

    }

    public void printInfo() {
        String info = "Name: " + this.getName() + " position: " + this.getX() + "," + this.getY() + " currentload: "
                + this.getCurrentWeight() + "tons";
        print(info);
    }

    public String returnInfo() {
        String info = "Name: " + this.getName() + " position: " + this.getX() + "," + this.getY() + " currentload: "
                + this.getCurrentWeight() + " tons";
        return info;
    }

    public static void print(String printthis) {
        System.out.println(printthis);
    }

    public String getName() {
        return name;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getCruiseSpeed() {
        return cruiseSpeed;
    }

    public void setCruiseSpeed(int cruiseSpeed) {
        this.cruiseSpeed = cruiseSpeed;
    }

    public int getX() {
        return x;
    }

    public void setX(int positionX) {
        this.x = positionX;
    }

    public int getY() {
        return y;
    }

    public void setY(int positionY) {
        this.y = positionY;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public boolean isIn_harbor() {
        return in_harbor;
    }

    public void setIn_harbor(boolean in_harbor) {
        this.in_harbor = in_harbor;
    }

    public String getHarborName() {
        return harborName;
    }

    public void setHarborName(String harborName) {
        this.harborName = harborName;
    }

    public void run() {
        try {
            route(x, y, pathNumber, cruiseSpeed);
        } catch (InterruptedException e) {

        }
    }

    public void route(int x, int y, int pathNumber, int speed) throws InterruptedException {
        int[][] path = Route.returnPath(pathNumber);
        if (in_harbor) {
            for (int i = 0; i < path.length; i++) {
                setIn_harbor(false);
                setX(path[i][0]);
                setY(path[i][1]);
                Thread.sleep(speed);
            }
        } else {
            for (int i = Route.getIndex(path, x, y); i < path.length; i++) {
                setIn_harbor(false);
                setX(path[i][0]);
                setY(path[i][1]);
                Thread.sleep(speed);
            }
            setIn_harbor(true);

        }

    }

    public void start() {
        System.out.println(name + " leave harbour.");
        if (t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }

}
