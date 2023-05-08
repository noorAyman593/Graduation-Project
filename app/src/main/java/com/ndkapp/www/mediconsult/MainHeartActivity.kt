package com.ndkapp.www.mediconsult

/*import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle*/

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainHeartActivity : AppCompatActivity() {
    var url = "https://nooraymanmohammed.pythonanywhere.com/predict"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_heart)

        var age = findViewById<EditText>(R.id.age)
        var sex = findViewById<Spinner>(R.id.sex)
        var cp = findViewById<Spinner>(R.id.cpS)
        var trestbps = findViewById<EditText>(R.id.trestbpsE)
        var chol = findViewById<EditText>(R.id.cholE)
        var ca = findViewById<Spinner>(R.id.caE)
        var fbs = findViewById<Spinner>(R.id.fbsE)
        var restecg = findViewById<Spinner>(R.id.restecgS)
        var exang = findViewById<Spinner>(R.id.exangS)
        var thalach = findViewById<EditText>(R.id.ThalacE)
        var oldpeak = findViewById<EditText>(R.id.OldPeakE)
        var slope = findViewById<Spinner>(R.id.slopeS)
        var thal = findViewById<Spinner>(R.id.ThalS)
        var predict = findViewById<Button>(R.id.predict)
        predict.setOnClickListener { // hit the API -> Volley
            val stringRequest: StringRequest =
                object : StringRequest(
                    Method.POST, url,
                    com.android.volley.Response.Listener { response ->
                        try {
                            val jsonObject = JSONObject(response)
                            val data = jsonObject.getString("placement")
                            if (data == "1") {
                                var intent = Intent(this,Predict_yes::class.java)
                                startActivity(intent)
                            } else {
                                var intent = Intent(this,Predict_No::class.java)
                                startActivity(intent)
                            }
                        } catch (e: JSONException) {
                            e.printStackTrace()
                        }
                    },
                    com.android.volley.Response.ErrorListener { error ->
                        Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show()
                        //                                result.setText("error");
                    }) {
                    override fun getParams(): Map<String, String>? {
                        val params: MutableMap<String, String> =
                            HashMap()
                        params["age"] = age.text.toString()
                        params["sex"] = sex.selectedItem.toString()
                        params["cp"] = cp.selectedItem.toString()
                        params["trestbps"] = trestbps.text.toString()
                        params["chol"] = chol.text.toString()
                        params["fbs"] = fbs.selectedItem.toString()
                        params["restecg"] = restecg.selectedItem.toString()
                        params["thalach"] = thalach.text.toString()
                        params["exang"] = exang.selectedItem.toString()
                        params["oldpeak"] = oldpeak.text.toString()
                        params["slope"] = slope.selectedItem.toString()
                        params["ca"] = ca.selectedItem.toString()
                        params["thal"] = thal.selectedItem.toString()
                        return params
                    }
                }
            val queue = Volley.newRequestQueue(this)
            queue.add(stringRequest)
        }
    }
}