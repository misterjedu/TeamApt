package com.jedun.teamaptexercise.ui

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.jedun.teamaptexercise.R
import com.jedun.teamaptexercise.databinding.FragmentSuccessBottomSheetBinding

private const val MESSAGE_PARAM = "message_param"

class SuccessBottomSheet : BottomSheetDialogFragment() {
    private var message: String? = null

    private var _binding: FragmentSuccessBottomSheetBinding? = null

    private val binding
        get() = _binding!!


    var bottomSheetListener: BottomSheetListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            message = it.getString(MESSAGE_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSuccessBottomSheetBinding.inflate(inflater, container, false)

        binding.successBottomSheetMessageTv.text = message

        binding.successBottomSheetAlrightButton.setOnClickListener {
            bottomSheetListener?.onCloseListener()
            dismiss()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            bottomSheetListener = parentFragment as BottomSheetListener
        } catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + "must implement BottomSheet Listener")
        }
    }


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = super.onCreateDialog(savedInstanceState) as BottomSheetDialog

        bottomSheetDialog.setOnShowListener { dialog: DialogInterface ->
            val dialogSheet = dialog as BottomSheetDialog
            val bottomSheet =
                dialogSheet.findViewById<ConstraintLayout>(R.id.success_bottom_sheet_root)
            val bottomSheetBehavior: BottomSheetBehavior<ConstraintLayout> =
                BottomSheetBehavior.from(bottomSheet as ConstraintLayout)

            val layoutParams = bottomSheet.layoutParams
            val windowHeight = getWindowHeight()

            if (layoutParams != null) {
                layoutParams.height = windowHeight
            }

            bottomSheet.layoutParams = layoutParams
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
        }

        return bottomSheetDialog
    }


    private fun getWindowHeight(): Int {
        return (context as Activity).findViewById<View>(Window.ID_ANDROID_CONTENT).height
    }


    companion object {
        @JvmStatic
        fun newInstance(message: String) =
            SuccessBottomSheet().apply {
                arguments = Bundle().apply {
                    putString(MESSAGE_PARAM, message)
                }
            }
    }

    interface BottomSheetListener {
        fun onCloseListener()
    }
}