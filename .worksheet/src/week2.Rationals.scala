package week2

object Rationals {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(61); 
  val x = new Rational(1,3);System.out.println("""x  : week2.Rational = """ + $show(x ));$skip(28); 
  val y = new Rational(5,7);System.out.println("""y  : week2.Rational = """ + $show(y ));$skip(28); 
  val z = new Rational(3,2);System.out.println("""z  : week2.Rational = """ + $show(z ));$skip(10); val res$0 = 
  x.numer;System.out.println("""res0: Int = """ + $show(res$0));$skip(10); val res$1 = 
  x.denom;System.out.println("""res1: Int = """ + $show(res$1));$skip(12); val res$2 = 
  x - y - z;System.out.println("""res2: week2.Rational = """ + $show(res$2));$skip(8); val res$3 = 
  y + y;System.out.println("""res3: week2.Rational = """ + $show(res$3));$skip(8); val res$4 = 
  x < y;System.out.println("""res4: Boolean = """ + $show(res$4));$skip(10); val res$5 = 
  x max y;System.out.println("""res5: week2.Rational = """ + $show(res$5));$skip(18); val res$6 = 
  new Rational(2);System.out.println("""res6: week2.Rational = """ + $show(res$6))}
}

class Rational(x: Int, y:Int) {
	require(y != 0, "denominator must be nonzero")
	
	//alternate constructor
	//calls another constructor with 2 arguments, the implicit primary constructor of class Rational
	def this(x:Int) = this(x,1)
	
		private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
	//private val g = gcd(x,y)
  //def numer = x/g
	//def denom = y/g
	//turn into vals so they are computed only once
	//val numer = x/ gcd(x,y)
	//val denom = y/ gcd(x,y)
	val numer = x
	val denom = y
	
	def < (that: Rational) =
	numer * that.denom < that.numer * denom
	
	def max(that: Rational) = if (this < that) that else this
	
	def + (that: Rational) =
	new Rational(
	numer * that.denom + that.numer * denom,
	denom * that.denom)
	
	def unary_- : Rational =
	new Rational(-numer, denom )
	
	//def sub(that:Rational) = add(that.neg)
	def - (that: Rational) = this + -that
	
	override def toString = {
	val g = gcd(numer, denom)
	numer/g + "/" + denom/g
	}
		
}
