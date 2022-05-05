class Product()
{
    private var name: String = "—"
    fun setName(n: String)
    {
        name = n
    }

    fun getName(): String
    {
        return name
    }
}

class Seller()
{
    private var inventory = mutableListOf<Product>()
    private var void_item = Product()
    fun showInventory()
    {
        if (inventory.isEmpty())
        {
            println("Товаров у вас нет!\n")
        }
        else
        {
            var number: Int = 0
            for (i in inventory)
            {
                number++
                println("$number.${i.getName()}")
            }
        }
    }
    fun toSell(number: Int): Product
    {
        if (number > inventory.size)
        {
            println("Такого товара не существует")
            return void_item
        }
        val i: Product = inventory[number - 1]
        inventory.removeAt(number - 1)
        return i
    }

    fun fillInventory()
    {
        val arr = arrayListOf<String>("Мышка", "Вебкамера", "Колонки", "Наушник", "Видеокарта", "Коврик", "Оперативка", "ссд диск")
        for (i in arr)
        {
            val it = Product()
            it.setName(i)
            inventory.add(it)
        }
    }
}

class Player()
{
    private var inventory = mutableListOf<Product>()
    fun showInventory()
    {
        if (inventory.isEmpty())
        {
            println("У вас ничего нет")
        }
        else
        {
            var number: Int = 0
            for (i in inventory)
            {
                number++
                println("$number.${i.getName()}")
            }
        }
    }
    fun toBuy(i: Product)
    {
        if (i.getName() == "—")
        {
            return
        }
        inventory.add(i)
        println("Товар добавлен")

    }
}
fun main()
{
    val player = Player()
    val seller = Seller()
    seller.fillInventory()
    var command: Int
    while (true) {
        println(">Чтобы посмотреть вашу корзину нажмите > 1")
        println(">Посмотреть товары продавца > 2")
        command = readLine()!!.toInt()
        if (command == 1)
        {
            player.showInventory()
        }
        else if (command == 2)
        {
            seller.showInventory()
            println(">Перейти в главное меню > 0")
            command = readLine()!!.toInt()
            if (command != 0) {
                player.toBuy(seller.toSell(command))
            }
            else continue
        }
    }
}