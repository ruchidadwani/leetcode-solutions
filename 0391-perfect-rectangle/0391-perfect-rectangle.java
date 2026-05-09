import java.util.*;

class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        Set<String> corners = new HashSet<>();
        
        long area = 0;

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;

        for (int[] r : rectangles) {
            int x1 = r[0], y1 = r[1];
            int x2 = r[2], y2 = r[3];

            // Total area
            area += (long)(x2 - x1) * (y2 - y1);

            // Bounding rectangle
            minX = Math.min(minX, x1);
            minY = Math.min(minY, y1);
            maxX = Math.max(maxX, x2);
            maxY = Math.max(maxY, y2);

            // Four corners
            String[] pts = {
                x1 + " " + y1,
                x1 + " " + y2,
                x2 + " " + y1,
                x2 + " " + y2
            };

            // Toggle corners in set
            for (String p : pts) {
                if (!corners.add(p)) {
                    corners.remove(p);
                }
            }
        }

        // Expected area
        long expectedArea = (long)(maxX - minX) * (maxY - minY);

        if (area != expectedArea) {
            return false;
        }

        // Exactly 4 corners should remain
        if (corners.size() != 4) {
            return false;
        }

        // They must be the 4 corners of bounding rectangle
        return corners.contains(minX + " " + minY) &&
               corners.contains(minX + " " + maxY) &&
               corners.contains(maxX + " " + minY) &&
               corners.contains(maxX + " " + maxY);
    }
}