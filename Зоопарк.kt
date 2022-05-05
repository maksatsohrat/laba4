class Zoo() {
    private class Aviary() {
        private class Animal() {
            private var name: String = ""
            private var gender: String = ""
            private var sound: String = ""

            fun getName(): String {
                if (name == "") return "unknown"
                return name }
            fun getGender(): String {
                if (gender == "") return "unknown"
                return gender }
            fun getSound(): String {
                if (sound == "") return "unknown"
                return sound }

            fun setName(n: String)   { name = n  }
            fun setGender(s: String) { gender = s}
            fun setSound(s: String)  { sound = s }

            fun setAll(_name: String, _sex: String, _sound: String) {
                name = _name
                gender = _sex
                sound = _sound }

            fun setTemplate(_name: String, Gender: String) {
                when { _name == "Зубр" -> {
                        name = "зубр"
                        sound = "хрюканье"
                    }
                    _name == "Слон" -> {
                        name = "слон"
                        sound = "ревение"
                    }
                    _name == "Пингвин" -> {
                        name = "пингвин"
                        sound = "тонкий писк"
                    }
                    _name == "Тигр" -> {
                        name = "тигр"
                        sound = "рычание"
                    }
                }
                gender = Gender
            }
        }
        private var inhabitants = mutableListOf<Animal>()
        private var number: Int = 0
        fun inhabit(n: Int, _name: String, _sex: String) {
            for (i in 1..n) {
                val a = Animal()
                a.setTemplate(_name, _sex)
                inhabitants.add(a)
            }
        }
        fun clear() { inhabitants.clear() }
        fun getNumber(): Int { return number }

        fun showInfo() {
            if (inhabitants.isEmpty()) {
                println("Тут пусто")
                return
            }
            var amount_of_male: Int = 0
            var amount_of_female: Int = 0
            for (i in inhabitants) {
                if (i.getGender() == "male") amount_of_female++
                else amount_of_male++
            }
            println("Вы пришли к вольеру с " + inhabitants[0].getName() + "ами")
            println("Тут живут ${inhabitants[0].getName()}" + "ы")
            println("В вольере $amount_of_male самец и $amount_of_female самки")
            println(inhabitants[0].getName() + " издаёт звук " + inhabitants[0].getSound())
        }
    }
    private var aviaries = mutableListOf<Aviary>()
    private var array_of_types = arrayListOf<String>("Зубр", "Слон", "Пингвин", "Тигр")
    fun create() {
        val a1 = Aviary()
        val a2 = Aviary()
        val a3 = Aviary()
        val a4 = Aviary()
        a1.inhabit(4, array_of_types[0], "male")
        a1.inhabit(3, array_of_types[0], "female")
        a2.inhabit(1, array_of_types[1], "male")
        a2.inhabit(3, array_of_types[1], "female")
        a3.inhabit(5, array_of_types[2], "male")
        a3.inhabit(8, array_of_types[2], "female")
        a4.inhabit(12, array_of_types[3], "male")
        a4.inhabit(14, array_of_types[3], "female")
        aviaries.add(a1)
        aviaries.add(a2)
        aviaries.add(a3)
        aviaries.add(a4)
    }
    fun getNumber(): Int {
        return aviaries.size
    }
    fun comeToAviary(num: Int) {
        if (num >= aviaries.size) {
            val number = num + 1
            println("Вольера под номером " + number + " не существует")
            return
        }
        aviaries[num].showInfo()
    }
}
fun main() {
    val zoo = Zoo()
    zoo.create()
    println("У нас ${zoo.getNumber()} вольера")
    while (true)
    {
        println("> К какому вольеру хотите подойти? Введите номер от 1 до 4 > ")
        zoo.comeToAviary(readLine()!!.toInt() - 1)
    }
}