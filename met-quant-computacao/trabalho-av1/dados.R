data.frame(data)
attach(data)

library(tidyverse)
library(kableExtra)
library(ggplot2)
library(dplyr)
library(tidyr)

# Tabelas

geraTabela <- function(variavel, nome_arquivo) {
  freq <- table(variavel)
  rel <- round(prop.table(freq) * 100, 2)
  
  df <- data.frame(
    Categoria = names(freq),
    Frequência = as.numeric(freq),
    `Frequência Relativa` = as.numeric(rel)
  )
  
  print(df, row.names = FALSE)
}

geraTabelaCruzada <- function(var1, var2, nome_var1 = "Escolaridade", nome_var2 = "Raça") {
  tabela_freq <- table(var1, var2)
  tabela_relativa <- round(prop.table(tabela_freq, margin = NULL) * 100, 2)
  
  df_final <- 
    as.data.frame(tabela_freq) %>%
    rename(Ocorrências = Freq) %>%
    left_join(
      as.data.frame(tabela_relativa) %>% rename(`Frequência Relativa (%)` = Freq),
      by = c("var1", "var2")
    ) %>%
    rename(
      !!nome_var1 := var1,
      !!nome_var2 := var2
    ) %>%
    arrange(!!sym(nome_var1))
  
  tabela_formatada <- df_final %>%
    kable(
      "html", 
      align = c("l", "l", "c", "c"),
      col.names = c(nome_var1, nome_var2, "Ocorrências", "Frequência Relativa (%)")
    ) %>%
    kable_styling(
      bootstrap_options = c("striped", "hover", "condensed"),
      full_width = FALSE
    ) %>%
    collapse_rows(columns = 1, valign = "top")
  
  print(tabela_formatada)
}


tab_natureza <- geraTabela(data$Natureza, "tabela_natureza")
tab_meio <- geraTabela(data$`Meio Empregado`, "tabela_meio_empregado")
tab_genero <- geraTabela(data$Gênero, "tabela_genero")
tab_escolaridade <- geraTabela(data$`Escolaridade da Vítima`, "tabela_escolaridade")
tab_raca <- geraTabela(data$`Raça da Vítima`, "tabela_raca")
tab_dia_da_semana <- geraTabela(data$`Dia da Semana`, "tabela_dia_semana")

tab_meio_vs_genero <- geraTabelaCruzada(data$Gênero, data$`Meio Empregado`)
tab_escolaridade_vs_raca <- geraTabelaCruzada(data$`Escolaridade da Vítima`, data$`Raça da Vítima`)


# Graficos

geraGraficoSetor <- function(variavel, nome_arquivo, largura = 8, altura = 6) {
  freq <- table(variavel) %>% 
    as.data.frame() %>%
    setNames(c("Categoria", "Frequência")) %>%
    mutate(Percentual = round(Frequência / sum(Frequência) * 100, 2))
  
  grafico <- ggplot(freq, aes(x = "", y = Percentual, fill = Categoria)) +
    geom_bar(width = 1, stat = "identity") +
    coord_polar("y", start = 0) +
    geom_text(
      aes(label = paste0(Percentual, "%")),
      position = position_stack(vjust = 0.5),
      size = 3.5,
      color = "black",
      fontface = "bold"
    ) +
    labs(fill = "") +
    theme_void() +
    theme(
      legend.position = "right",
      legend.text = element_text(size = 10),
      legend.key.size = unit(0.5, "cm"),
      legend.margin = margin(0, 15, 0, 0),
      plot.margin = margin(1, 4, 1, 1, "cm")
    )
  
  ggsave(nome_arquivo, plot = grafico, width = largura, height = altura, dpi = 300)
}

geraGraficoDias <- function(variavel, nome_arquivo) {
  ordem_dias <- c("Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado")
  
  freq <- table(variavel) %>% 
    as.data.frame() %>%
    setNames(c("Dia", "Frequência")) %>%
    mutate(Dia = factor(Dia, levels = ordem_dias))
  
  ggplot(freq, aes(x = Dia, y = Frequência, fill = Dia)) +
    geom_bar(stat = "identity", width = 0.7) +
    geom_text(aes(label = Frequência), vjust = -0.5, size = 3.5, color = "black") +
    labs(x = "", y = "") +
    theme_minimal() +
    theme(
      axis.text.x = element_text(angle = 45, hjust = 1, size = 10),
      axis.text.y = element_blank(),
      legend.position = "none",
      plot.margin = margin(1, 1, 2, 1, "cm")
    ) +
    scale_fill_brewer(palette = "Set2") 
  
  ggsave(nome_arquivo, width = 10, height = 6, dpi = 300)
}

geraGraficoEscolaridade <- function(variavel, nome_arquivo) {
  freq <- table(variavel) %>% 
    as.data.frame() %>%
    setNames(c("Escolaridade", "Frequência")) %>%
    mutate(Escolaridade = factor(Escolaridade)) %>% 
    arrange(Escolaridade)
  
  ggplot(freq, aes(x = Escolaridade, y = Frequência, fill = Escolaridade)) +
    geom_bar(stat = "identity", width = 0.7) +
    geom_text(aes(label = Frequência), vjust = -0.5, size = 3.5, color = "black") +
    labs(x = "", y = "") +
    theme_minimal() +
    theme(
      axis.text.x = element_text(angle = 45, hjust = 1, size = 10),
      axis.text.y = element_blank(),
      legend.position = "none",
      plot.margin = margin(1, 1, 2, 1, "cm")
    ) +
    scale_fill_brewer(palette = "Pastel1") 
  
  ggsave(nome_arquivo, width = 12, height = 7, dpi = 300)
}


geraGraficoAno <- function(variavel_data, nome_arquivo = "g_linha_ano.png") {
  dados_plot <- data.frame(
    Data = variavel_data
  ) %>%
    mutate(
      Ano = format(as.Date(Data, format = "%d/%m/%y"), "%Y")
    ) %>%
    count(Ano) %>%
    rename(Ocorrencias = n)
  
  ggplot(dados_plot, aes(x = Ano, y = Ocorrencias, group = 1)) +
    geom_line(color = "#2c3e50", linewidth = 1) +
    geom_text(
      aes(label = Ocorrencias), 
      vjust = -0.8, 
      color = "#2c3e50",
      size = 3
    ) +
    ylim(0, max(dados_plot$Ocorrencias) * 1.1) +
    geom_point(color = "#e74c3c", size = 2) +
    labs(x = "Ano", y = "Número de Ocorrências") +
    theme_minimal() +
    theme(
      panel.grid.minor = element_blank(),
      axis.text.x = element_text(angle = 45, hjust = 1)
    )
  
  ggsave(nome_arquivo, width = 8, height = 6, dpi = 300)
}

geraGraficoHora <- function(variavel_hora, nome_arquivo = "g_linha_hora.png") {
  dados_plot <- data.frame(Hora = variavel_hora) %>%
    mutate(
      Hora = format(as.POSIXct(Hora, format = "%H:%M:%S"), "%H")
    ) %>%
    count(Hora) %>%
    rename(Ocorrencias = n) %>%
    complete(Hora = sprintf("%02d", 0:23), fill = list(Ocorrencias = 0)) %>%
    mutate(Hora = factor(Hora, levels = sprintf("%02d", 0:23)))
  
  ggplot(dados_plot, aes(x = Hora, y = Ocorrencias, group = 1)) +
    geom_line(color = "#3498db", linewidth = 1) +
    geom_point(color = "#9b59b6", size = 2) +
    geom_text(
      aes(label = Ocorrencias),
      vjust = -1.5,
      color = "#2c3e50",
      size = 3
    ) +
    labs(x = "Hora do Dia", y = "Número de Ocorrências") +
    theme_minimal() +
    theme(
      panel.grid.minor = element_blank(),
      axis.text.x = element_text(angle = 90, hjust = 1)
    ) +
    ylim(0, max(dados_plot$Ocorrencias) * 1.1)
  
  ggsave(nome_arquivo, width = 10, height = 6, dpi = 300)
}


analisar_idade <- function(idade) {
  idade_limpa <- idade %>%
    as.character() %>%              
    gsub("[^0-9]", "", .) %>%       
    as.numeric() %>%                
    .[!is.na(.)] %>%              
    .[. >= 0 & . <= 120]
  
  if(length(idade_limpa) == 0) stop("Nenhum dado válido para análise")
  

  medidas_posicao <- list(
    "Média" = round(mean(idade_limpa), 2),
    "Mediana" = median(idade_limpa),
    "Moda" = {
      tab <- table(idade_limpa)
      as.numeric(names(tab)[which.max(tab)])
    },
    "Quartis" = quantile(idade_limpa, probs = c(0.25, 0.5, 0.75)),
    "Decis" = quantile(idade_limpa, probs = seq(0.1, 0.9, 0.1)),
    "Percentis (5% e 95%)" = quantile(idade_limpa, probs = c(0.05, 0.95))
  )
  

  medidas_dispersao <- list(
    "Desvio Padrão" = round(sd(idade_limpa), 2),
    "Variância" = round(var(idade_limpa), 2),
    "Amplitude Total" = diff(range(idade_limpa)),
    "Intervalo Interquartil (IQR)" = IQR(idade_limpa),
    "Coeficiente de Variação (%)" = round((sd(idade_limpa)/mean(idade_limpa))*100, 2)
  )
  

  boxplot <- ggplot(data.frame(Idade = idade_limpa), aes(y = Idade)) +
    geom_boxplot(
      fill = "#D3D3D3", 
      color = "#34495E",  
      outlier.shape = NA, 
      width = 0.5       
    ) +
    labs(x = "Idade das Vítimas (anos)", y = "") +
    theme_minimal() +
    theme(
      panel.grid.major.y = element_blank(),
      panel.grid.minor = element_blank(),
      axis.text.y = element_blank(),
      axis.line.x = element_line(color = "black"),
      axis.ticks.x = element_line(color = "black"),
      plot.margin = margin(10, 20, 10, 20)
    ) +
    scale_x_continuous(breaks = seq(0, 120, by = 10))
  
  
  ggsave("boxplot_idades.png", plot = boxplot, 
         width = 8, height = 6, dpi = 300)

  list(
    "Dados Analisados" = length(idade_limpa),
    "Medidas de Posição" = medidas_posicao,
    "Medidas de Dispersão" = medidas_dispersao,
    "Visualização" = boxplot,
    "Arquivo_Salvo" = "boxplot_idades.png"
  )
}

geraGraficoSetor(data$Gênero, "g_pie_genero.png")
geraGraficoSetor(data$`Meio Empregado`, "g_pie_meio.png")
geraGraficoEscolaridade(data$`Escolaridade da Vítima`, "g_barra_escolaridade.png")
geraGraficoDias(data$`Dia da Semana`, "g_barra_dias.png")
geraGraficoAno(data$Data)
geraGraficoHora(data$Hora)

resultados <- analisar_idade(data$`Idade da Vítima`)

print(resultados)
