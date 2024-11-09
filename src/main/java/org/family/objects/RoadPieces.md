# RoadPiece Documentation

This document provides an overview of the different types of road pieces used in the project, their unique type IDs, rotation options, and descriptions.

## RoadPiece Types

Each `RoadPiece` type has a unique `id` that represents the type of track segment, along with an orientation (rotation) that affects how the segment connects with others. These pieces are commonly used to build track layouts in a structured, programmatic way.

| RoadPiece ID | Type Description         | Rotation Options          | Details                                      |
|--------------|--------------------------|---------------------------|----------------------------------------------|
| **33**       | Straight Track           | `0°`, `90°`, `180°`, `270°` | A straight segment that connects in a line.  |
| **34**       | Curved Track             | `0°`, `90°`, `180°`, `270°` | A curved segment used to form turns.         |
| **41**       | Intersection Track       | `0°`, `90°`, `180°`, `270°` | An intersection allowing multiple directions.|
| **39**       | Finish Line              | `0°`, `90°`, `180°`, `270°` | Finish line segment to indicate end of race. |
| **35**       | Risers                   | `0°`, `90°`, `180°`, `270°` | Adds elevation to the track.                 |
| **38**       | Launch Kit Track (Jump)  | `0°`, `90°`, `180°`, `270°` | A segment designed for jumps or air tricks.  |
| **42**       | Collision Kit Track (X intersection) | `0°`, `90°`, `180°`, `270°` | An X-shaped intersection for collision courses.|

### Rotation Enum

The `Rotation` enum is used to set the orientation of each `RoadPiece`. Below are the valid rotations:

- `DEGREE_0`: 0°
- `DEGREE_90`: 90°
- `DEGREE_180`: 180°
- `DEGREE_270`: 270°

These rotations allow flexibility in connecting track pieces in various layouts, ensuring that each segment aligns with others as expected.

### Example Usage

Below is a simple example of creating a `RoadPiece` and setting its rotation.

```java
RoadPiece straightTrack = new RoadPiece(33, RoadPiece.Rotation.DEGREE_0);
RoadPiece curvedTrack = new RoadPiece(34, RoadPiece.Rotation.DEGREE_90);

// Set rotation if needed
straightTrack.setRotation(RoadPiece.Rotation.DEGREE_180);
