package com.example.kaspressoreport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kaspressoreport.databinding.FragmentFlakyBinding
import kotlinx.coroutines.*

private const val TIMEOUT_MS = 2_000L

class FlakyFragment : Fragment() {

    private var _binding: FragmentFlakyBinding? = null
    private var counter = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFlakyBinding.inflate(inflater, container, false)
        binding.textviewFlaky.text = getString(R.string.flaky_counter, counter)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonPrev.setOnClickListener {
            findNavController().navigate(R.id.action_flakyFragment_pop2)
        }
        binding.buttonCount.setOnClickListener {
            GlobalScope.launch {
                delay(TIMEOUT_MS)
                withContext(Dispatchers.Main) {
                    counter++
                    binding.textviewFlaky.text = getString(R.string.flaky_counter, counter)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}