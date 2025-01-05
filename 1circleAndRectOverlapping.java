class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        // Find the closest point to the circle center (xCenter, yCenter) on the rectangle
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Calculate the distance between the circle center and this closest point
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;

        // Check if the distance is less than or equal to the radius
        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
    }
}
