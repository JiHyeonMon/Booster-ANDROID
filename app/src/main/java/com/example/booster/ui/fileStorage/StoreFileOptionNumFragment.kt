package com.example.booster.ui.fileStorage


import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.widget.Toast
import androidx.fragment.app.DialogFragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.booster.R
import com.example.booster.listener.onlyOneClickListener
import kotlinx.android.synthetic.main.dialog_store_file_option_num.*

class StoreFileOptionNumFragment : DialogFragment() {

    private var mCallback: FragmentToActivity? = null

    private var printOption: Int = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.dialog_store_file_option_num, container, false)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState).apply {
            window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        order_dialog_btn_close_black.onlyOneClickListener {
            dismiss()
        }

        order_option_btn_minus.onlyOneClickListener {

            printOption = edt_printNum.text.toString().toInt() - 1
            if(printOption<1){
                Toast.makeText(context, "최소 1부 이상 선택가능합니다.", Toast.LENGTH_SHORT).show()
                printOption = 1
            }
            else{
                edt_printNum.setText(printOption.toString())
            }
        }

        order_option_btn_plus.onlyOneClickListener {
            printOption = edt_printNum.text.toString().toInt() + 1
            edt_printNum.setText(printOption.toString())
        }


        dial_store_file_option_num.onlyOneClickListener {
            sendData(printOption)

            dismiss()
        }

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mCallback = try {
            context as FragmentToActivity
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString()
                        + " must implement FragmentToActivity"
            )
        }
    }

    override fun onDetach() {
        mCallback = null;
        super.onDetach();
    }

    fun sendData(num:Int)
    {
        mCallback!!.communicateNum(num);

    }
}
