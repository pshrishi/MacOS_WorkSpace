object SqrtExample {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  def abs(x: Double) =
  	if(x>0) x else -x;System.out.println("""abs: (x: Double)Double""");$skip(133); 
  	
  def sqrtIter(guess: Double, x: Double): Double =
    if (isGoodEnough(guess, x)) guess
    else sqrtIter(improve(guess, x), x);System.out.println("""sqrtIter: (guess: Double, x: Double)Double""");$skip(94); 
    
    def isGoodEnough(guess: Double, x: Double) =
    	abs(guess * guess - x) / x < 0.001;System.out.println("""isGoodEnough: (guess: Double, x: Double)Boolean""");$skip(75); 
    	
    def improve(guess: Double, x: Double) =
    	(guess + x/guess)/2;System.out.println("""improve: (guess: Double, x: Double)Double""");$skip(49); 
    	
    def sqrt(x: Double) = sqrtIter(1.0, x);System.out.println("""sqrt: (x: Double)Double""");$skip(17); val res$0 = 
    
    sqrt(2);System.out.println("""res0: Double = """ + $show(res$0));$skip(12); val res$1 = 
    sqrt(4);System.out.println("""res1: Double = """ + $show(res$1));$skip(15); val res$2 = 
    sqrt(1e-6);System.out.println("""res2: Double = """ + $show(res$2));$skip(15); val res$3 = 
    sqrt(1e60);System.out.println("""res3: Double = """ + $show(res$3))}
}
