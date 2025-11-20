# 💰 Conversor de Moedas | Challenge ONE - Back End Java

## 🎯 Sobre o Projeto
Este projeto foi desenvolvido como parte do programa **Oracle Next Education (ONE)** em parceria com a Alura. É uma aplicação de console (linha de comando) que simula um conversor de moedas, obtendo as taxas de câmbio em **tempo real** através de uma API externa.

O foco principal do projeto é demonstrar proficiência em:
* Consumo de **APIs REST** via `HttpClient` (Java 11+).
* Desserialização de dados **JSON** usando a biblioteca **Gson**.
* Utilização de **Variáveis de Ambiente** (`System.getenv()`) para segurança da API Key.
* Manipulação de coleções (`ArrayList`) para rastrear o **Histórico de Conversões**.

---

## ✨ Funcionalidades

O sistema oferece um menu interativo com as seguintes capacidades:

* **Taxas em Tempo Real:** Todas as cotações são dinamicamente atualizadas através da *ExchangeRate-API*.
* **Menu Interativo:** Oferece 6 opções predefinidas de conversão (e.g., USD -> BRL, EUR -> BRL).
* **Histórico de Conversões:** Rastreia e exibe todas as transações realizadas na sessão atual, incluindo data e hora.
* **Tratamento de Exceções:** Gerenciamento de erros ao chamar a API ou ao digitar entradas inválidas no console.

---

## 🛠️ Tecnologias Utilizadas
![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=openjdk&logoColor=white)

| Tecnologia | Versão | Descrição |
| :--- | :--- | :--- |
| **Java JDK** | 21+ | Linguagem base do projeto. |
| **Gson** | 2.10.1 | Biblioteca para mapeamento JSON para Objetos Java (Records). |
| **HttpClient** | Nativo (Java 11+) | Para fazer as requisições HTTP à API. |
| **API** | ExchangeRate-API | Fonte de dados em tempo real para as cotações. |
| **IDE** | IntelliJ IDEA | Ambiente de desenvolvimento. |

---

## ⚙️ Como Rodar a Aplicação

Para executar o projeto localmente, siga os passos abaixo:

### 1. Obter a Chave API

Este projeto requer uma chave da *ExchangeRate-API*.
1.  Crie uma conta gratuita no site da **ExchangeRate-API**.
2.  Obtenha sua chave (`API Key`).

### 2. Configurar a Variável de Ambiente

Para manter a segurança (e seguir as boas práticas), a chave API é carregada via Variável de Ambiente.

No seu IntelliJ:
1.  Vá em **Run** > **Edit Configurations...**.
2.  No campo **Environment Variables**, adicione uma nova variável com o seguinte par:
    * **Nome:** `API_KEY_CONVERSOR`
    * **Valor:** `SUA_CHAVE_PESSOAL_AQUI` (Ex: `x0x0x0x0x0x0x0x0x0x0x`)

### 3. Execução

1.  Clone este repositório:
    ```bash
    git clone [link do seu repositório]
    ```
2.  Abra o projeto no IntelliJ.
3.  Execute a classe principal (`Main.java`).
4.  O menu interativo será exibido no console.

---

## 🧑‍💻 Autor

**Laura Rocha** | **Dev Back End Java em formação**

📧 **Email:** [cristinarod.laura@gmail.com

**LinkedIn:** www.linkedin.com/in/laura-rocha98

🌐 **GitHub:** https://github.com/cristina-rod
