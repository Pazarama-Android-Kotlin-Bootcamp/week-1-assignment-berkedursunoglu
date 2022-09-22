fun main(args: Array<String>) {

    //We run the function that the user wants to run by receiving data from when.
    println("Choise a assingment \"1\",\"2\",\"4\",\"5\".")
    when(readLine()){
        "1" -> {
            println("--------------------Assingment 1 Check---------------------------")

            println("First Input:\"aa_\" Expect False ")
            println(codeUserNameValidation("aa_"))
            println("First Input:\"u__hello_world123\" Expect True ")
            println(codeUserNameValidation("u__hello_world123"))
        }
        "2" -> {
            println("--------------------Assingment 2 Check---------------------------")
            /*We divide the string value received from the user into spaces with the split method, so we have an array.
            We use the map method to convert the string type to int. Our function expects an array value,
            so we translate the resulting list reference into array.*/
            println("Enter numbers with spaces between them.")
            val array = readLine()?.trim()?.split(" ")?.map { it.toInt() }?.toTypedArray()
            println(veryBigSum(array!!))
        }
        "3" -> {
            println("--------------------Assingment 4 Check---------------------------")

            println("First Input:\"4\" Expect \"24\" ")
            println(firstFactorial(4)) // Expect 24
            println("First Input:\"8\" Expect \"40320\" ")
            println(firstFactorial(8)) // Expect 40320
        }
        "4" -> {
            println("--------------------Assingment 5 Check---------------------------")

            println("First Input:\"arrb6???4xxbl5???eee5\" Expect \"true\" ")
            println(questionsMarks("arrb6???4xxbl5???eee5"))
            println("First Input:\"aa6?9\" Expect \"false\" ")
            println(questionsMarks("aa6?9"))
            println("First Input:\"acc?7??sss?3rr1??????5\" Expect \"true\" ")
            println(questionsMarks("acc?7??sss?3rr1??????5"))
        }
    }
}


//Assingment 1
private fun codeUserNameValidation(userName: String): String {
    //We define an initial value to loop through the given string.
    var charPositions = 0

    //If the string value is between 4 and 25, we continue our operation, otherwise we return false value.
    if (userName.length in 4..25) {

        /*We are checking whether the first character of the string value is a letter,
        if it is true, we enter it into if, otherwise we return false value.*/
        if (userName[0].isLetter()) {

            //We check if the last character of the value is not "_".
            if (userName[userName.length - 1] != '_') {

                /*After all the required single checks are done, we check the letter,
                number and "_" in each character of the variable.*/
                while (charPositions < userName.length) {
                    if (userName[charPositions].isLetterOrDigit() || userName[charPositions] == '_') {
                        charPositions++
                    } else return "false"
                }
                return "true"
            } else return "false"
        } else return "false"
    } else return "false"
}

//Assingment 2
private fun veryBigSum(array: Array<Int>): Long {
    //The variable to which we will pass the sum of the data in the incoming array.
    var sum: Long = 0

    /* We use the forEach function to handle array elements one by one,
    Each incoming array element is collected with the variable "sum"
    and thrown into the variable "sum." */
    array.forEach { sum += it }
    return sum
}


//Assingment 4
private fun firstFactorial(num: Int): Int {
    //The variable definition to which the factorial result will be passed.
    var result = 1

    /*Multiplying the given variable by the factorial
     variable and assigning it to the factorial variable.*/
    for (i in 1..num) {
        result *= i
    }

    return result
}

//Assingment 5
private fun questionsMarks(str: String): String {
    //Initializing required variables in the loop
    var firstNumber = 0
    var secondNumber = 0
    var whileLoop = 0
    var result = ""

    //for loop where we will return all characters
    for (i in 0..str.length) {

        //The loop, will loop until it sees the first number.
        if (str[i].isDigit()) {

            //We assign the first number that appears to the variable.
            firstNumber = str[i].digitToInt()

            //For a second loop we take one more loop than the first.
            whileLoop = i + 1

            if (whileLoop != str.length){
                var questMark = 0

                //We are checking if Bound of exceptions is not thrown.
                while (whileLoop < str.length) {

                    /*For each question mark we see after the first number that appears,
                    we increment the variable whileLoop by one.If we encounter a number,
                    we break the while loop.*/
                    if (str[whileLoop] == '?') {
                        questMark++
                    } else if (str[whileLoop].isDigit()) {
                        secondNumber = str[whileLoop].digitToInt()
                        break
                    }
                    whileLoop++
                }

                /*
                After the while loop, we query whether the two numbers
                we get are equal to 10 and the questionsMark variable is equal to 3,
                and we assign true-false according to the conditions.
                 */
                if ((firstNumber + secondNumber) == 10 && questMark == 3) {
                    result = "true"
                    break
                } else {
                    result = "false"
                }

            }else break
        }
    }
    return result
}