public class Fraction {

    private int n;
    
    private int d;

    public Fraction(int numerator,int denominator) {
        n = numerator;
        d = denominator;
        if (d == 0) {
            System.out.println("Error! Zero Denominator, setting it to 1");
            d = 1;
        } else {
            this.d = d;
        }
    }
    
    public Fraction(){
        this.n = 1;
        this.d = 1;
    }   
    
    public Fraction(String x){
        int i = x.indexOf("/");
        String a = x.substring(0,i);
        String b = x.substring(i+1);
        n = Integer.parseInt(a);
        d = Integer.parseInt(b);
        if (d == 0) {
            System.out.println("Error! Zero Denominator, setting it to 1");
            d = 1;
        } else {
            this.d = d;
        }
    }
    
    public Fraction(Fraction x){
        this.n = x.n;
        this.d = x.d;
    }
   
////////////////////////////////////////////////////////////////////

     public int getNum() {
        return this.n;
    }

    public int getDenom() {
        return this.d;
    }
    
    public String toString() { 
        String x = this.getNum() + "/" + this.getDenom();
        return x;
    }

    public double toDecimal() {
        double deci = this.n/this.d;
        return deci;
    }

    public void reduce() { 
        int gcd = gcd(this.n, this.d);
        this.n = this.n / gcd;
        this.d = this.d / gcd; 

    }
    
    
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        if (a == 0 || b == 0)
        {
            return 1;
        }

        while (a != b)
        {
            if (a > b){
                a = a - b;
            }else{
                b = b - a;
            }        
        }
        return a;
    }
    
    public void multiply(Fraction f1){
        this.n = this.n*f1.n;
        this.d = this.d*f1.d;
        this.reduce();
    }
    
    public static Fraction multiply(Fraction f1, Fraction f2){
        int newn = f1.n * f2.n;
        int newd = f1.d * f2.d;
        Fraction f3 = new Fraction(newn,newd);
        f3.reduce();
        return f3;
    
    }
   
    public static Fraction add (Fraction a, Fraction b) {
        int newNum = a.n * b.d + b.n * a.d;
        int newDen = a.d * b.d;
        Fraction newf = new Fraction(newNum, newDen);
        newf.reduce();
        return newf;
    }

    public static Fraction subtract (Fraction a, Fraction b) {      
        int newNum = a.n * b.d - b.n * a.d;
        int newDen = a.d * b.d;
        Fraction newf = new Fraction(newNum, newDen);
        newf.reduce();
        return newf;
    }
    
    public static Fraction divide(Fraction a, Fraction b) {
        if (b.n == 0) {
            System.out.println("Error, cannot divide by zero; returning a default fraction");
            return new Fraction();
        } else {
            Fraction reciprocal = b.getReciprocal();
            Fraction ans = Fraction.multiply(a, reciprocal);
            ans.reduce();
            return ans;

        }
    }

     private Fraction getReciprocal() {
        Fraction reciprocal = new Fraction(this.d, this.n);
        return reciprocal;
    }


}