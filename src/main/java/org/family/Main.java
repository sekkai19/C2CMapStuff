package org.family;
import org.family.objects.RoadPiece;
import org.family.objects.RoadNetwork;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RoadPiece roadPiece1 = new RoadPiece(1, RoadPiece.Rotation.DEGREE_0);
        RoadPiece roadPiece2 = new RoadPiece(2, RoadPiece.Rotation.DEGREE_90);
        RoadPiece roadPiece3 = new RoadPiece(3, RoadPiece.Rotation.DEGREE_180);

        RoadNetwork roadNetwork = new RoadNetwork();
        roadNetwork.addRoadPiece(roadPiece1);
        roadNetwork.addRoadPiece(roadPiece2);
        roadNetwork.connectPieces(1, 2);
        roadNetwork.addRoadPiece(roadPiece3);

        roadNetwork.connectPieces(1, 3);
        roadNetwork.connectPieces(2,3);
        roadNetwork.displayConnections();
        System.out.println(roadNetwork.checkMapIntegrity());
    }
}