# Wit-Android-Challenge

Este repositório contém o código-fonte de um aplicativo Android desenvolvido como um requisito para a oportunidade de trabalho em Android Software Developer (Moçambique - África) na WIT Software.
O aplicativo faz solicitações para [OpenWeatherApi] ​​(https://openweathermap.org/current) e analisa sua resposta Json para obter o clima da minha cidade `Maputo` e 10 cidades europeias` Lisboa, Madrid, Paris, Berlim, Copenhague, Roma , Londres, Dublin, Praga e Viena ».

Bibliotecas usadas
--------------
* [Android Jetpack] (https://developer.android.com/jetpack) - é um conjunto de bibliotecas para ajudar os desenvolvedores a seguir as práticas recomendadas, reduzir o código clichê e escrever código que funcione de forma consistente em todas as versões e dispositivos Android para que os desenvolvedores possam concentre-se no código com o qual eles se importam.
* [Dagger Hilt] (https://dagger.dev/hilt/) - Uma biblioteca que fornece uma maneira padrão de incorporar a injeção de dependência Dagger em um aplicativo Android.
* [Glide] (https://github.com/bumptech/glide) - Um gerenciamento de mídia de código aberto rápido e eficiente e uma estrutura de carregamento de imagens para Android
* [Gson] (https://github.com/google/gson) - Uma biblioteca Java que pode ser usada para converter objetos Java em sua representação JSON.
* [Retrofit2] (https://square.github.io/retrofit/) - Um cliente HTTP de tipo seguro para Android e Java.
* [Kotlin Coroutines] (https://kotlinlang.org/docs/coroutines-guide.html) - uma rica biblioteca para corrotinas desenvolvida pela JetBrains.
* [SDP] (https://github.com/intuit/sdp) - Uma biblioteca do Android que fornece uma unidade de tamanho escalonável.
* [SSP] (https://github.com/intuit/ssp) - Uma biblioteca do Android que fornece uma unidade de tamanho escalonável para textos.

## Pré-requisitos
Para testar este código:
* Substitua o valor `API_KEY` [aqui] (https://github.com/Felcio/Wit-Challenge-Android/blob/main/app/src/main/java/com/felcio/wit_android_challenge/utils/Constants.kt) com sua própria chave de API (Obtenha-a [aqui] (https://openweathermap.org/))