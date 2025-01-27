package com.guga.supp4youapp.presentation.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.guga.supp4youapp.R
import com.guga.supp4youapp.databinding.FragmentGenerateBinding
import com.guga.supp4youapp.presentation.ui.camera.CameraActivity

class GenerateFragment : Fragment(R.layout.fragment_generate) {

    private var _binding: FragmentGenerateBinding? = null
    val binding get() = _binding!!
    private var spaceId: String? = null
    private var personName: String? = null
    private var groupName: String? = null
    private var selectedDays: String? = null
    private var selectBeginTime: String? = null
    private var selectEndTime: String? = null
    private var timeStamp: Long? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGenerateBinding.inflate(inflater, container, false)
        spaceId = arguments?.getString("spaceId")
        personName = arguments?.getString("personName")
        groupName = arguments?.getString("groupName")
        selectedDays = arguments?.getString("selectDays")
        selectBeginTime = arguments?.getString("selectBeginTime")
        selectEndTime = arguments?.getString("selectEndTime")
        timeStamp = arguments?.getLong("timestamp")
        binding.tvEntercode.text = spaceId

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvContinue.setOnClickListener {
            spaceId?.let { id ->
                val intent = Intent(requireContext(), CameraActivity::class.java)
                intent.putExtra("groupId", id)
                intent.putExtra("personName", personName)
                intent.putExtra("groupName", groupName)
                intent.putExtra("selectDays", selectedDays)
                intent.putExtra("selectBeginTime", selectBeginTime)
                intent.putExtra("selectEndTime", selectEndTime)
                intent.putExtra("timeStamp", timeStamp)
                startActivity(intent)
            }
        }
        binding.tvShare.setOnClickListener {
            spaceId?.let { id ->
                val whatsappIntent = Intent(Intent.ACTION_SEND)
                whatsappIntent.type = "text/plain"
                val text = "Would you like to join $groupName? The code is: $id"
                whatsappIntent.setPackage("com.whatsapp")

                whatsappIntent.putExtra(Intent.EXTRA_TEXT, text)
                try {
                    startActivity(whatsappIntent)
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "WhatsApp can not be open", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.backIcon.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
