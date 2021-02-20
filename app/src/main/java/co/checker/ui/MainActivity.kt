package co.checker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import co.checker.R
import co.checker.core.Countries
import co.checker.core.Types
import co.checker.databinding.ActivityMainBinding
import co.checker.domain.IUseCaseMainImpl
import co.checker.domain.code.IUseCaseCodeImpl
import co.checker.domain.target.IUseCaseTargetImpl
import co.checker.presentation.MainViewModel
import co.checker.presentation.MainViewModelFactory
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>{ MainViewModelFactory (IUseCaseMainImpl(
            IUseCaseTargetImpl(), IUseCaseCodeImpl()
    )) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        btn_check_target.setOnClickListener { checkTarget() }
        btn_check_code.setOnClickListener { checkCode() }
    }

    fun checkTarget() {
        val card: String = eTxt.text.toString()
        if(card != "") {
            txt_valid.text = "Valid: ${viewModel.checkTarget(card)}"
            var imgUrl = ""
            when(viewModel.getType(card)) {
                Types.AMERICAN_EXPRESS.toString() -> {
                    imgUrl = "https://puntosglobales.com/wp-content/uploads/2018/10/american-express-gold-card2.png"
                }
                Types.VISA.toString() -> {
                    imgUrl = "https://www.bbva.com.co/content/dam/public-web/colombia/new-beginning/tarjetas-credito/visa-clasica.png.img.960.1559857091691.png"
                }
                Types.MASTERCARD.toString() -> {
                    imgUrl = "https://scotiabankfiles.azureedge.net/scotiabank-colombia/scotiabank-colpatria/imagenes/tarjetas/Master_Gold_Aadvantage_600x380.png"
                }
                else -> {
                    imgUrl = "https://previews.123rf.com/images/cthoman/cthoman1508/cthoman150802713/43362622-una-ilustraci%C3%B3n-de-dibujos-animados-de-un-archivo-desconocido-en-ejecuci%C3%B3n-.jpg"
                }
            }
            Glide.with(this).load(imgUrl).centerCrop().into(img_ref)
        }else eTxt.error = "It's empty"
    }

    fun checkCode() {
        val code: String = eTxt.text.toString()
        if(code.length >= 3) {
            txt_valid.text = "Valid: ${viewModel.checkCode(code)}"
            var imgCountryUrl = ""
            Log.d("country2", "country: ${viewModel.getCountry(code)}")
            when(viewModel.getCountry(code)) {
                Countries.EEUU.code -> {
                    imgCountryUrl = "https://i.pinimg.com/736x/a2/fb/af/a2fbaf34cb56f414b17ed77ad80c7bf0.jpg"
                }
                Countries.BULGARIA.code -> {
                    imgCountryUrl = "https://media.istockphoto.com/photos/flag-of-bulgaria-background-picture-id966187940?k=6&m=966187940&s=612x612&w=0&h=WlFo7QzGPIEy1TGRtJ0060iPz6aY8RbrkVQQUq4yFzk="
                }
                Countries.INGLATERRA.code -> {
                    imgCountryUrl = "https://image.freepik.com/foto-gratis/bandera-inglaterra_1048-3362.jpg"
                }
                Countries.IRLANDA.code -> {
                    imgCountryUrl = "https://previews.123rf.com/images/antimartina/antimartina1705/antimartina170500023/78275118-ilustraci%C3%B3n-vectorial-de-una-bandera-de-irlanda-pintada-con-pinceladas.jpg"
                }
                Countries.PORTUGAL.code -> {
                    imgCountryUrl = "https://i.pinimg.com/originals/62/ea/f0/62eaf04b79b678c400e3315bf2b77c9b.jpg"
                }
                Countries.NORUEGA.code -> {
                    imgCountryUrl = "data:image/jpeg;base64,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"
                }
                Countries.VENEZUELA.code -> {
                    imgCountryUrl = "https://i.pinimg.com/564x/26/b8/7e/26b87ec005339ffd79d27e6cf031b4f3.jpg"
                }
                Countries.CUBA.code -> {
                    imgCountryUrl = "https://besthqwallpapers.com/Uploads/20-9-2017/21107/thumb2-cuban-flag-cuba-latin-america-silk-flag-emblems.jpg"
                }
                Countries.INDIA.code -> {
                    imgCountryUrl = "https://crisenlaindia79.files.wordpress.com/2013/09/images4.jpg"
                }
                else -> {
                    imgCountryUrl = "https://previews.123rf.com/images/cthoman/cthoman1508/cthoman150802713/43362622-una-ilustraci%C3%B3n-de-dibujos-animados-de-un-archivo-desconocido-en-ejecuci%C3%B3n-.jpg"
                }
            }
            Glide.with(this).load(imgCountryUrl).centerCrop().into(img_ref)
        }else eTxt.error = "It's too short"
    }
}