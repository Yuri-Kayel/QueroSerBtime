package yuri.kayel.dojopuzzles.presenter

import yuri.kayel.bookofeulogies.util.Pop.successSnack
import yuri.kayel.bookofeulogies.util.Util.context
import yuri.kayel.bookofeulogies.util.Util.hideKeyboard
import yuri.kayel.dojopuzzles.R

class FragDiamondsPresenter(var view : IFragDiamondsView)
{
    private val error = context.getString(R.string.not_valid_letter)
    private val alphabet = arrayOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")

    init
    {
        view.setPresenter(this)
    }

    fun updateOutput(input : String)
    {
        successSnack("OK")

        hideKeyboard()

        if (validCharacter(input))
        {
            val output = buildDiamond(input)
            checkProperTextSize(input)
            view.display(output)
        }
        else
        {
            view.display(error)
        }
    }

    private fun checkProperTextSize(input : String)
    {
        when (input)
        {
            "Z", "Y" -> view.setOutputTextSize(9f)
            "X", "W", "V" -> view.setOutputTextSize(10f)
            "U", "T" -> view.setOutputTextSize(11f)
            "S" -> view.setOutputTextSize(12f)
            "R" -> view.setOutputTextSize(13f)
            "Q" -> view.setOutputTextSize(14f)
            "P" -> view.setOutputTextSize(15f)
            else -> view.setOutputTextSize(16f)
        }
    }

    private fun buildDiamond(input : String) : String
    {
        var index = 0

        for (letter in alphabet)
        {
            index++
            if (input == letter) break
        }

        val output = StringBuilder()
        var letterIterator = 0
        var midIterator = 1

        for (iteration in 0 until index - 1)
        {
            marginLeft(letterIterator, index, output, false)

            output.append(alphabet[letterIterator])

            if (letterIterator != 0)
            {
                for (i in 0 until midIterator)
                {
                    output.append(" ")
                }
                output.append(alphabet[letterIterator])
                midIterator += 2
            }

            output.append("\n")

            letterIterator++
        }

        for (iteration in index - 1 downTo 0)
        {
            marginLeft(letterIterator, index, output, true)

            output.append(alphabet[letterIterator])

            if (letterIterator != 0)
            {
                for (i in midIterator - 1 downTo 0)
                {
                    output.append(" ")
                }
                output.append(alphabet[letterIterator])
                midIterator -= 2
            }

            output.append("\n")
            letterIterator--
        }

        return output.toString()
    }

    private fun marginLeft(letterIterator : Int,
                           target : Int,
                           output : StringBuilder,
                           reverse : Boolean)
    {
        if (reverse)
        {
            for (i in letterIterator until target)
            {
                output.append(" ")
            }
        }
        else
        {
            for (i in letterIterator until target)
            {
                output.append(" ")
            }
        }
    }

    private fun validCharacter(input : String) : Boolean
    {
        for (letter in alphabet)
        {
            if (input == letter) return true
        }
        return false
    }


    interface IFragDiamondsView
    {
        fun setPresenter(presenter : FragDiamondsPresenter)

        fun display(input : String)

        fun setOutputTextSize(size : Float)
    }
}
