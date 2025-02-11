package com.example.bukuinduk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.ImageView
import android.view.Gravity
import androidx.lifecycle.ViewModelProvider

class RequestFragment : Fragment() {

    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_request, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inisialisasi ViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(SharedViewModel::class.java)

        val nextButton = view.findViewById<ImageButton>(R.id.nextbtn)
        val pendingContainer = view.findViewById<FrameLayout>(R.id.pending_container)

        nextButton?.setOnClickListener {
            val transaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, PengajuanFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        // Observe perubahan status pending
        sharedViewModel.isPending.observe(viewLifecycleOwner) { isPending ->
            pendingContainer.removeAllViews()

            if (isPending) {
                val pendingImageView = ImageView(requireContext())
                pendingImageView.setImageResource(R.drawable.pending2) // Ganti dengan gambar yang sesuai

                // Atur posisi gambar agar tidak mepet ke kiri
                val layoutParams = FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    gravity = Gravity.CENTER // Posisikan gambar di tengah
                    setMargins(50, 0, 50, 0) // Beri margin kiri & kanan agar lebih rapi
                }

                pendingImageView.layoutParams = layoutParams
                pendingContainer.addView(pendingImageView)
            }
        }
    }
}
