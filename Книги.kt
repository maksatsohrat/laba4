class books(private var Name: String, private var Avtor: String, private var GodIzdanie: Int)
{
    private var name: String = this.Name
    private var avtor: String = this.Avtor
    private var godizdanie: Int = this.GodIzdanie
    fun getName(): String
    {
        return name
    }
    fun getAvtor(): String
    {
        return avtor
    }
    fun getGodIzdanie(): Int
    {
        return godizdanie
    }
    fun VyvodInformasii()
    {
        println("Название книги: " + name + "\nАвтор: " + avtor + "\nГод издание: " + godizdanie)
    }
}
fun main()
{
    val book_depository = mutableListOf<books>()
    var command: Int = 0
    while (true)
    {
        println("> Добавить книгу нажмите > 1 ")
        println("> Удалить книгу нажмите > 2 ")
        println("> Чтобы показать все книги > 3 ")
        println("> Чтобы показать книги по определённому параметру > 4 ")
        command = readLine()!!.toInt()

        when
        {
            command == 1 ->
            {
                print("\n>Введите название: ")
                val name: String = readLine()!!.toString()
                print("\n>Введите автора: ")
                val avtor: String = readLine()!!.toString()
                print("\n>Введите год издания: ")
                val godizdanie: Int = readLine()!!.toInt()
                println()
                val instance = books(name, avtor, godizdanie)
                book_depository.add(instance)
                println(">Книга добавлена\n")
            }
            command == 2 ->
            {
                println("\n>Введите порядковый номер книги")
                val number: Int = readLine()!!.toInt()
                if (number > book_depository.size)
                {
                    println("\nНе существует книги с таким порядковым номером!\n")
                }
                else
                {
                    book_depository[number].VyvodInformasii()
                    book_depository.removeAt(number - 1)
                    println("\nКнига успешно удалена.\n")
                }
            }
            command == 3 ->
            {
                println("Список книг:")
                var number: Int = 0
                for (i in book_depository) {
                    number++
                    println("Порядковый номер > " + number + " <\n")
                    i.VyvodInformasii()
                    println()
                }
                println("Конец списка\n")
            }
            command == 4 ->
            {
                println(">По названию нажмите > 1")
                println(">По автору > 2")
                println(">По году издания > 3")
                command = readLine()!!.toInt()
                when {
                    command == 1 -> {
                        var number: Int = 0
                        print(">Введите название: ")
                        val name: String = readLine().toString()
                        println(">Начало списка\n")
                        for (i in book_depository) {
                            number++
                            if (i.getName().contains(name)) {
                                println("Порядковый номер > " + number + " <\n")
                                i.VyvodInformasii()
                                println()
                            }
                        }
                        println("Конец списка\n\n")
                    }
                    command == 2 ->
                    {
                        var number: Int = 0
                        print("Введите автора\t")
                        val avtor: String = readLine().toString()
                        println("Начало списка\n")
                        for (i in book_depository)
                        {
                            number++
                            if (i.getAvtor().contains(avtor))
                            {
                                println("Порядковый номер > " + number + " <\n")
                                i.VyvodInformasii()
                                println()
                            }
                        }
                        println("Конец списка\n")
                    }
                    command == 3 ->
                    {
                        var number: Int = 0
                        print("Введите 1 если хотите определённый год издания\n")
                        print("Введите 2 если хотите после определённого года\n")
                        print("Введите 3 если хотите до определённого года издания\n")
                        command = readLine()!!.toInt()
                        when {
                            command == 1 ->
                            {
                                var number: Int = 0
                                print("Введите год: ")
                                val date: Int = readLine()!!.toInt()

                                println("Начало списка\n")
                                for (i in book_depository)
                                {
                                    number++
                                    if (i.getGodIzdanie() == date)
                                    {
                                        println("Порядковый номер > " + number + " <")
                                        i.VyvodInformasii()
                                        println()
                                    }
                                }
                                println("Конец списка\n")
                            }
                            command == 2 ->
                            {
                                var number: Int = 0
                                print("Введите год: ")
                                val date: Int = readLine()!!.toInt()

                                println("Начало списка\n")
                                for (i in book_depository)
                                {
                                    number++
                                    if (i.getGodIzdanie() >= date)
                                    {
                                        println("Порядковый номер > " + number + " <\n")
                                        i.VyvodInformasii()
                                        println()
                                    }
                                }
                                println("Конец списка\n")
                            }
                            command == 3 ->
                            {
                                var number: Int = 0
                                print("Введите год: ")
                                val date: Int = readLine()!!.toInt()

                                println("Начало списка\n")
                                for (i in book_depository)
                                {
                                    number++
                                    if (i.getGodIzdanie() <= date) {
                                        println("Порядковый номер > " + number + " <\n")
                                        i.VyvodInformasii()
                                        println()
                                    }
                                }
                                println("Конец списка\n")
                            }
                        }
                    }
                }
            }
        }
    }
}