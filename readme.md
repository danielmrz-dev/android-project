## Members:

Daniel Mariz
RM: 566721

Douglas Cristian
RM: 566847

Nome: Beatriz Cavalcanti
RM: 568493

Bruna Sangoleti
RM: 567014

Wesley Santos
RM: 567925

## Objetivo

O FoodRescue nasceu para ser uma plataforma 100% focada em ESG, atacando dois problemas de uma vez: o desperdício de alimentos e a insegurança alimentar. A ideia é usar a geolocalização para conectar estabelecimentos locais e pessoas que têm alimentos excedentes diretamente com ONGs e grupos em situação de vulnerabilidade.

Um dos nossos maiores pilares é a **transparência e a dignidade na doação**. Por isso, nós não adotamos modelos genéricos como o de "sacolas surpresa". No nosso app, a pessoa ou a instituição vê exatamente os itens que estão disponíveis e escolhe aquilo que realmente faz sentido e atende às suas necessidades. Isso garante que ninguém receba algo que não pode ou não quer consumir, evitando que a comida vá para o lixo de novo.

Para manter as empresas e os usuários engajados na causa, o aplicativo evidencia o impacto prático de cada ação. Cada resgate gera relatórios e métricas em tempo real, mostrando o resultado daquela atitude: quantas refeições foram salvas, quantas famílias foram ajudadas e a quantidade de emissão de CO2 (pegada de carbono) que foi evitada.

## Tecnologias e Justificativas

Para o desenvolvimento do MVP do FoodRescue, optamos por uma arquitetura focada em agilidade e desenvolvimento nativo, garantindo a melhor experiência no ecossistema mobile. As escolhas tecnológicas foram orientadas pela necessidade de construir e validar a solução de forma rápida, segura e alinhada às boas práticas de mercado.

*   **Linguagem de Programação (Kotlin):** Optamos pelo desenvolvimento Android nativo com Jetpack Compose. Essa escolha garante acesso direto e otimizado aos recursos do hardware do dispositivo (como câmera e GPS), entregando máxima performance e uma interface fluida.
*   **Ambiente de Desenvolvimento (Android Studio):** Utilizamos a IDE oficial do Google para o ecossistema Android. Ela nos fornece um conjunto robusto de ferramentas e emuladores integrados para testes ágeis, acelerando drasticamente o ciclo de desenvolvimento das telas e da lógica de negócio.
*   **Versionamento e Colaboração (Git e GitHub):** Adotamos o Git para o controle de versão. O repositório no GitHub atua como nossa central de colaboração, permitindo a gestão de código (Branches e Pull Requests), o acompanhamento do fluxo de trabalho (Kanban/Issues) e a documentação padronizada do projeto.
*   **Infraestrutura Backend (Firebase):** Para cumprir o requisito de não desenvolver um back-end do zero nesta fase, o Firebase atua como nosso BaaS (Backend as a Service). Ele permite gerenciar o banco de dados em tempo real para as listagens de alimentos e estruturar as variáveis de impacto social de forma rápida e escalável.
*   **Geolocalização (Google Maps API):** Integrada para mapear os doadogit add readme.mdres e os pontos de resgate. A visualização espacial é crítica para a logística do aplicativo, pois o usuário precisa saber exatamente a distância e a rota até a doação.

## Design

https://www.figma.com/design/ZXv4ECqH63CI6iaHDtxSEo/FoodRescue?node-id=0-1&t=lVHpYbrWIrIUuDNs-0