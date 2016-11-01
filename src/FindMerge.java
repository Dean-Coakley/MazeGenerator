
public class FindMerge {

    int[] data;

    public FindMerge() {
        this(1);
    }


    public FindMerge(int k) {
        if (k > 0) {
            this.data = new int[k];
            for (int i = 0; i < k; i++) {
                this.data[i] = -1;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int find(int i) {
        if (this.data[i] < 0) {
            return i;
        }
        this.data[i] = this.find(this.data[i]);
        return this.data[i];
    }

  
    public void merge(int a, int b) {

        int rootA = this.find(a);
        int rootB = this.find(b);
        int sizeA = this.data[rootA];
        int sizeB = this.data[rootB];

        if (sizeA < sizeB) {
            this.data[rootA] = rootB;
            this.data[rootB] += sizeA;
        } else {
            this.data[rootB] = rootA;
            this.data[rootA] += sizeB;
        }
    }

    public int getNoSubsets() {
        int count = 0;
        for (int i = 0; i < this.data.length; i++) {
            if (this.data[i] < 0) {
                count++;
            }
        }
        return count;
    }    
}
