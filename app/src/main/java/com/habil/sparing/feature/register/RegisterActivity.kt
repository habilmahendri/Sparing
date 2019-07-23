package com.habil.sparing.feature.register

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.view.inputmethod.InputMethodManager
import com.habil.sparing.R
import com.habil.sparing.model.User
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity(), RegisterContract.View {
    lateinit var mPresenter: RegisterPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        cb_term.text = HtmlCompat.fromHtml(
            "I Read and agree to <font color='#0071D0'><u>Terms & Conditions</u></font>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )
        mPresenter = RegisterPresenter(this)

        btn_register.setOnClickListener {
            btn_register.isEnabled = false
            btn_register.text = "Tunggu ya..."
            hideKeyboard()

            if (edt_email.text.toString().trim().isNotEmpty() && edt_fullname.text.toString().trim().isNotEmpty()
                && edt_password.text.toString().trim().isNotEmpty() &&
                edt_username.text.toString().trim().isNotEmpty() &&
                edt_phone.text.toString().trim().isNotEmpty() && edt_teamName.text.toString().trim().isNotEmpty()
            ) {
                if (cb_term.isChecked) {
                    val user = User(
                        full_name = edt_fullname.text.toString(),
                        email = edt_email.text.toString(),
                        user_name = edt_username.text.toString(),
                        phone_number = edt_phone.text.toString(),
                        team_name = edt_teamName.text.toString(),
                        password = edt_password.text.toString()
                    )
                    mPresenter.getUser(user)
                } else {
                    btn_register.isEnabled = true
                    btn_register.text = "Register"
                }


            } else {
                btn_register.isEnabled = true
                btn_register.text = "Register"
                toast("masukkan data dengan benar")

            }
        }


    }

    fun Activity.hideKeyboard() {
        val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = currentFocus
        if (view != null) {
            inputManager.hideSoftInputFromWindow(view.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    override fun userRegister() {
        finish()

    }

    override fun message(message: String) {
        btn_register.isEnabled = true
        btn_register.text = "Register"
        toast(message)
    }
}
