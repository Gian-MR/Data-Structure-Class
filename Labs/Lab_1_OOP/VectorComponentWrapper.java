package Labs.Lab_1_OOP;

public class VectorComponentWrapper {

    public static interface BaseVector {
        public double getXComponent();

        public double getYComponent();

        public double getMagnitude();

        public double getAngle();

        public BaseVector add(BaseVector V);

        public BaseVector subtract(BaseVector V);

        public double dotProduct(BaseVector V);

        public BaseVector crossProduct(BaseVector V);
    }

    public static class VectorComponent implements BaseVector {

        private double X;
        private double Y;


        public VectorComponent(double X, double Y) {
            this.X = X;
            this.Y = Y;
        }

        @Override
        public double getXComponent() {
            return X;
        }

        @Override
        public double getYComponent() {
            return Y;
        }

        public void setX(double x) {
            this.X = x;
        }

        public void setY(double y) {
            this.Y = y;
        }

        @Override
        public BaseVector add(BaseVector V) {
            double newX = X + V.getXComponent();
            double newY = Y + V.getYComponent();

            return new VectorComponent(newX, newY);
        }

        @Override
        public BaseVector subtract(BaseVector V) {
            double newX = X - V.getXComponent();
            double newY = Y - V.getYComponent();

            return new VectorComponent(newX, newY);
        }

        @Override
        public double dotProduct(BaseVector V) {
            return X * V.getXComponent() + Y * V.getYComponent(); 
        }

        @Override
        public BaseVector crossProduct(BaseVector V) {
            throw new UnsupportedOperationException("Cross product not defined for 2D vectors");
        }
        @Override
        public double getMagnitude() {
            return Math.sqrt(X * X + Y * Y);
        }

        @Override
        public double getAngle() {
            return Math.toDegrees(Math.atan2(Y, X)); 
        }
    }
}
