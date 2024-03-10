/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.vsk.demoapp;

import java.util.Objects;

/**
 * Model of a point in two dimensions.
 * Class is immutable.
 */
public final class Point {

    /**
     * Point is in no quadrant.
     */
    private static final int NO_QUADRANT = 0;

    /**
     * Quadrant 1. Positive x, Positive y.
     */
    private static final int QUADRANT_1 = 1;

    /**
     * Quadrant 1. Negative x, Positive y.
     */
    private static final int QUADRANT_2 = 2;

    /**
     * Quadrant 1. Negative x, Negative y.
     */
    private static final int QUADRANT_3 = 3;

    /**
     * Quadrant 4. Positive x, Negative y.
     */
    private static final int QUADRANT_4 = 4;

    private final int x;
    private final int y;

    /**
     * Constructor for point with coordinates.
     *
     * @param x x-Coordinate.
     * @param y y-Coordinate.
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gets the quadrant in which the point lies.
     * If coordinates on axes or on (0,0) it returns 0
     *
     * @return number of quadrant.
     */
    public int getQuadrant() {
        int quadrant = NO_QUADRANT;
        if (this.x != 0 && this.y != 0) {
            if (this.x > 0) {
                if (this.y > 0) {
                    quadrant = QUADRANT_1;
                } else {
                    quadrant = QUADRANT_4;
                }
            } else {
                if (this.y > 0) {
                    quadrant = QUADRANT_2;
                } else {
                    quadrant = QUADRANT_3;
                }
            }
        }
        return quadrant;
    }

    /**
     * Gets the x-coordinate.
     *
     * @return x-coordinate of the point.
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gets the y-coordinate.
     *
     * @return y-coordinate of the point.
     */
    public int getY() {
        return y;
    }

    /**
     * Two points with same coordinates are equal.
     * {@inheritDoc}.
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        return obj instanceof Point p && this.x == p.x && this.y == p.y;
    }

    /**
     * Gets the hashcode based on x and y-coordinates.
     * {@inheritDoc}.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    /**
     * Gets a string representation for the point.
     * {@inheritDoc}.
     */
    @Override
    public String toString() {
        return "Point[x=" + this.x + ",y=" + this.y + "]";
    }
}
