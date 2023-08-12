package laboratory

//Objetos singleton/Singleton objects

object Balance{
    //Expressões lambda/lambda expressions
    var tara: Double = 0.00
    var pressure: Double = 0.00
    //hypothetical: 1 press = 1kg
    var result: Double = 0.00

    fun toWeight(tara: Double,press: Double){
        //hypothetical calculation:
        this.result = (this.pressure*1)-this.tara
    }
}

object Burner{
    //Lambdas finais/final lambdas
    var burning: Boolean = false
    fun burn(start: Boolean){
        this.burning = start

    }
}

object CombustionSpoon {
    var burningSpoon: Boolean = false
    fun burnSpoon(start: Boolean) {
        this.burningSpoon = start
    }
}


object Dropper {
    var liquid: Double = 0.0

    fun cleanDropper(){
        this.liquid = 0.0
    }

    fun getLiquid(drop: Double) {
        this.liquid = this.liquid + drop
    }

    fun dropLiquid(drop:Double){
        this.liquid = this.liquid -drop
    }

    fun dropStatus(): Double {
        return this.liquid
    }

}


object Microscope{
    var zoom: Double = 1.0
    fun zooming(zoomFactor: Double){
        this.zoom = zoomFactor
    }
}
