package tech.llcat.tij.ch19;

public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String name = name();
        String lower = name.substring(1).toLowerCase();
        return name.charAt(0)+lower;
    }

    public static void main(String[] args) {
        for(SpaceShip ship: SpaceShip.values()){
            System.out.println(ship);
        }
    }

}
