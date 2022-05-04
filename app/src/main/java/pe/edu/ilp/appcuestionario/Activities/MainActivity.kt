package pe.edu.ilp.appcuestionario.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import pe.edu.ilp.appcuestionario.R
import pe.edu.ilp.appcuestionario.model.Pregunta

class MainActivity : AppCompatActivity() {

    var preguntas = ArrayList<Pregunta>()
    var posicionActual = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Este método añade preguntas a la lista
        cargarPreguntas()
        //Este método muestra las preguntas al usuario
        mostrarPreguntas()

        val btnVerdad = findViewById<android.view.View>(R.id.btnVerdadero)
        btnVerdad.setOnClickListener{
            if (preguntas[posicionActual].respuesta)(
                Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
            )
           else
                Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()

        }

        val btnIncorrecto = findViewById<android.view.View>(R.id.btnFalso)
        btnIncorrecto.setOnClickListener{
            if(!preguntas[posicionActual].respuesta){
                Toast.makeText(this,"La respuesta es correcta", Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(this,"La respuesta es incorrecta", Toast.LENGTH_SHORT).show()

        }

        val btnNext = findViewById<Button>(R.id.btnSiguiente)
        btnNext.setOnClickListener{
            try{
                posicionActual ++
                mostrarPreguntas()
            } catch (e: Exception) {
                Toast.makeText(this,"No existe mas preguntas",Toast.LENGTH_SHORT).show()
            }
        }

        val btnAtras = findViewById<Button>(R.id.btn_atras)
        btnAtras.setOnClickListener{
            try{
                posicionActual --
                mostrarPreguntas()
            } catch (e: Exception) {
                Toast.makeText(this,"No existe mas preguntas Atras",Toast.LENGTH_SHORT).show()
            }
        }

    }
    fun cargarPreguntas() {
        preguntas.add(Pregunta("Caracas es la capital de Venezuela",true))
        preguntas.add(Pregunta("Piura es un departamento que pertenece a Ecuador", false))
        preguntas.add(Pregunta("Uruguay es un país Latinoamericano", true))
        preguntas.add(Pregunta("Lima es la capital de Chile", false))
    }

    private fun mostrarPreguntas() {
        val textoPregunta = findViewById<TextView>(R.id.tvPregunta)
        textoPregunta.text = preguntas[posicionActual].enunciado
    }

}




                                      /*___     -._
                                        `-. """--._ `-.
                                           `.      "-. `.
                             _____           `.       `. \
                            `-.   """---.._    \        `.\
                               `-.         "-.  \         `\
                                  `.          `-.\          \_.-""""""""--._
                                    `.           `                          "-.
                                      `.                                       `.    __....-------...
                            --..._      \                                       `--"""""""""""---..._
                            __...._"_-.. \                       _,                             _..-""
                            `-.      """--`           /       ,-'/|     ,                   _.-"
                               `-.                 , /|     ,'  / |   ,'|    ,|        _..-"
                                  `.              /|| |    /   / |  ,'  |  ,' /        ----"""""""""_`-
                                    `.            ( \  \      |  | /   | ,'  //                 _.-"
                                      `.        .'-\/'""\ |  '  | /  .-/'"`\' //            _.-"
                                /'`.____`-.  ,'"\  ''''?-.V`.   |/ .'..-P''''  /"`.     _.-"
                               '(   `.-._""  ||(?|    /'   >.\  ' /.<   `\    |P)||_..-"___.....---
                                 `.   `. "-._ \ ('   |     `8      8'     |   `) /"""""    _".""
                                   `.   `.   `.`.b|   `.__            __.'   |d.'  __...--""
                                     `.   `.   ".`-  .---      ,-.     ---.  -'.-""
                                       `.   `.   ""|      -._      _.-      |""
                                         `.  .-"`.  `.       `""""'       ,'
                                           `/     `.. ""--..__    __..--""
                                            `.      /7.--|    """"    |--.__
                                              ..--"| (  /'            `\  ` ""--..
                                           .-"      \\  |""--.    .--""|          "-.
                                          <.         \\  `.    -.    ,'       ,'     >
                                         (P'`.        `%,  `.      ,'        /,' .-"'?)
                                         P    `. \      `%,  `.  ,'         /' .'     \
                                        | --"  _\||       `%,  `'          /.-'   .    )
                                        |       `-.""--..   `%..--"""\\"--.'       "-  |
                             _Marco_     \          `.  .--"""  "\.\.\ \\.'       )     |*/