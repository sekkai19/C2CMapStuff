package org.family.objects;

import java.util.ArrayList;
import java.util.List;

public class RoadPiece {
    public enum Rotation {
        DEGREE_0(0), DEGREE_90(90), DEGREE_180(180), DEGREE_270(270);

        private final int degrees;

        Rotation(int degrees) {
            this.degrees = degrees;
        }

        public int getDegrees() {
            return degrees;
        }

        public static Rotation fromDegrees(int degrees) {
            for (Rotation rotation : Rotation.values()) {
                if (rotation.getDegrees() == degrees) {
                    return rotation;
                }
            }
            throw new IllegalArgumentException("Invalid rotation degrees: " + degrees);
        }
    }

    private int id;  // Represents the type
    private Rotation rotation;
    private List<RoadPiece> connections;  // List of connected road pieces

    public RoadPiece(int id, Rotation rotation) {
        this.id = id;
        this.rotation = rotation;
        this.connections = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public Rotation getRotation() {
        return rotation;
    }

    public List<RoadPiece> getConnections() {
        return connections;
    }

    public void addConnection(RoadPiece roadPiece) {
        connections.add(roadPiece);
    }
}
