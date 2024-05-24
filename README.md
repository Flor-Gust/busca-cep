# Projeto Busca CEP com Java e Spring Boot
![arquivo](https://github.com/Flor-Gust/chess-system-java/assets/152279549/7b15fb8d-400e-4040-a052-4398bf60e03d)
<br/>

# Sobre

### **Projeto: API que calcula frete por região - Consumindo API VIACEP**

Este projeto é uma API REST desenvolvida em Java utilizando o framework Spring, com o objetivo de calcular o frete passando o CEP pelo corpo da requisição. A arquitetura da API segue os princípios REST, proporcionando uma interface de fácil utilização para interações baseadas em HTTP.

### **Arquitetura do projeto**

No projeto foi usado a arquitetura hexagonal, utilizei essa arquitetura para estudos e aprendizado. 

A arquitetura hexagonal, também chamada de Arquitetura de "Portas" e "Adaptadores", é projetada para promover a reusabilidade, coesão e baixo acoplamento em sistemas. No centro dessa arquitetura está um núcleo independente de detalhes de implementação externa. Ele define funcionalidades abstratas, enquanto interfaces chamadas "portas" especificam métodos a serem executados. As implementações concretas dessas portas são fornecidas por "adaptadores", que traduzem as chamadas do núcleo para ações específicas do ambiente externo, como acesso a bancos de dados. Isso permite flexibilidade e fácil manutenção, pois as mudanças na infraestrutura podem ser feitas sem alterar o núcleo central, resultando em baixo acoplamento.

    
<div style="display: flex;">
    <img src="https://github.com/Flor-Gust/busca-cep/assets/152279549/6bf0b16e-ebe0-4892-a6e7-aa8117c77a3e" alt="pastas">
    <img src="https://github.com/Flor-Gust/busca-cep/assets/152279549/e4888df3-b9b1-4ed0-93da-150000713553" alt="estrutura-hexagonal" >
</div>

 ### **Objetivo geral:**
- Consumir API de terceiro.
- Implementar arquitetura hexagonal.
- Tratar exceções personalizadas.
- Implementar associações entre objetos.
- Objetos aninhados.

# Tecnologias utillizadas

<div style="display: inline-block"><br/>
    <img align="center" alt="logo linguagem java" src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white">
    <img align="center" alt="logo Spring" src="https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white">
</div><br/>

 # Testando aplicação

https://github.com/Flor-Gust/busca-cep/assets/152279549/56ca0e4f-0e4c-4fda-a4b2-66ed26c5a759

# Autor
**Luan Flor Gustavo**

LinkedIn: https://www.linkedin.com/in/luan-flor-2287b2262

E-mail: luan.flor05@gmail.com

<br/>


## Dependências Externas

Este projeto faz uso da API VIACEP para obter informações sobre endereços a partir de CEPs. A API VIACEP é utilizada para validar e buscar detalhes de endereços a partir dos CEPs fornecidos pelos usuários. 

Para mais informações sobre a API VIACEP, consulte a documentação oficial em [https://viacep.com.br/](https://viacep.com.br/).
