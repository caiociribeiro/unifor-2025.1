data.frame(data)
attach(data)

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

# Criar CSVs para cada variável
geraTabela(data$Natureza, "tabela_natureza")
geraTabela(data$`Meio Empregado`, "tabela_meio_empregado")
geraTabela(data$Gênero, "tabela_genero")
geraTabela(data$`Escolaridade da Vítima`, "tabela_escolaridade")
geraTabela(data$`Raça da Vítima`, "tabela_raca")
geraTabela(data$`Dia da Semana`, "tabela_dia_semana")

