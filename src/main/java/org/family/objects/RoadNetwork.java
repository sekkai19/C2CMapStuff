package org.family.objects;

import org.family.objects.RoadPiece;
import java.util.HashMap;
import java.util.Map;

public class RoadNetwork {
    private Map<Integer, RoadPiece> roadPieces;  // Stores each RoadPiece by unique ID
    private int autoIncrementId;  // Unique ID generator

    public RoadNetwork() {
        roadPieces = new HashMap<>();
        autoIncrementId = 1;  // Start unique IDs at 1
    }

    // Adds a new RoadPiece to the network, assigning it a unique ID
    public int addRoadPiece(RoadPiece roadPiece) {
        int uniqueId = autoIncrementId++;
        roadPieces.put(uniqueId, roadPiece);
        return uniqueId;  // Return the unique ID for later use
    }
    public boolean checkMapIntegrity(){
        for(int i = 1; i < autoIncrementId; i++){
            if(roadPieces.get(i) == null){
                return false;
            }
            if(roadPieces.get(i).getConnections().size()!=2){
                return false;
            }

        }
        return true;
    }
    // Connects two road pieces by their unique IDs
    public void connectPieces(int uniqueId1, int uniqueId2) {
        RoadPiece piece1 = roadPieces.get(uniqueId1);
        RoadPiece piece2 = roadPieces.get(uniqueId2);

        if (piece1 != null && piece2 != null) {
            piece1.addConnection(piece2);
            piece2.addConnection(piece1);  // For an undirected graph
        } else {
            System.out.println("One or both pieces not found!");
        }
    }

    // Display connections
    public void displayConnections() {
        for (Map.Entry<Integer, RoadPiece> entry : roadPieces.entrySet()) {
            int uniqueId = entry.getKey();
            RoadPiece piece = entry.getValue();
            System.out.print("RoadPiece ID " + uniqueId + " (Type " + piece.getId() + ") connected to: ");
            for (RoadPiece connectedPiece : piece.getConnections()) {
                System.out.print("Type " + connectedPiece.getId() + " ");
            }
            System.out.println();
        }
    }
}
