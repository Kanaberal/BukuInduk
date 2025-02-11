package com.example.bukuinduk

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class PengajuanFragment : Fragment() {

    private lateinit var formContainer: FrameLayout
    private lateinit var formSpinner: Spinner
    private lateinit var btnKirim: Button
    private lateinit var btnKembali: Button
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_pengajuan, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        formSpinner = view.findViewById(R.id.form_spinner)
        formContainer = view.findViewById(R.id.form_container)
        btnKirim = view.findViewById(R.id.kirim)
        btnKembali = view.findViewById(R.id.kembali)

        val adapter = ArrayAdapter.createFromResource(
            requireContext(),
            R.array.form_options,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        formSpinner.adapter = adapter

        formSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                formContainer.removeAllViews()
                val layoutInflater = LayoutInflater.from(requireContext())
                val layoutResId = when (position) {
                    0 -> R.layout.activity_blank
                    1 -> R.layout.activity_request_data_diri
                    2 -> R.layout.activity_request_alamatsiswa
                    3 -> R.layout.activity_request_kesehatan
                    4 -> R.layout.activity_request_pendidikan
                    5 -> R.layout.activity_request_keterangan_ayah
                    6 -> R.layout.activity_request_ibu
                    7 -> R.layout.activity_request_perkembangan
                    8 -> R.layout.activity_request_lulus
                    else -> null
                }
                layoutResId?.let { layoutInflater.inflate(it, formContainer, true) }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        btnKirim.setOnClickListener {
            sharedViewModel.setPendingStatus(true)
            val intent = Intent(requireContext(), tampilansucces::class.java)
            startActivity(intent)
        }

        btnKembali.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}
