# Passo a passo do projeto
# Passo 1: Entrar no sistema da empresa
  # https://dlp.hashtagtreinamentos.com/python/intensivao/login

import pyautogui
import time
import pandas

# pyautogui.click -> clicar com o mouse
# pyautogui.write -> escrever um texto
# pyautogui.press -> apertar 1 tecla
# pyautogui.hotkey -> atalho (combinação de teclas)

pyautogui.PAUSE = 0.3

# abrir o Chrome
pyautogui.press("win")
pyautogui.write("chrome")
pyautogui.press("enter")

# Entrar no link
link = "https://dlp.hashtagtreinamentos.com/python/intensivao/login"
pyautogui.write(link)

# Esperar o site carregar
time.sleep(3)

# Passo 2: Fazer login
pyautogui.click(x=773, y=455) # clicks = 2
pyautogui.write("pythonimpressionador@gmail.com")

pyautogui.press("tab") # passar para o campo de senha
pyautogui.write("senha")

pyautogui.press("tab") # passei para o botão de login
pyautogui.press("enter")

# Passo 3: Importar a base de dados de produtos
import pandas

tabela = pandas.read_csv("produtos.csv")
print(tabela)

for linha in tabela.index:
    # Passo 4: Cadastrar 1 produto
    pyautogui.click(x=756, y=300)

    codigo = tabela.loc[linha, "codigo"]
    marca  = tabela.loc[linha, "marca"]
    tipo   = tabela.loc[linha, "tipo"]
    categoria  = tabela.loc[linha, "categoria"]
    preco_unitario  = tabela.loc[linha, "preco_unitario"]
    custo  = tabela.loc[linha, "custo"]
    
    obs  = tabela.loc[linha, "obs"]
    if not pandas.isna(obs):
        pyautogui.write(str(obs))
        

    # Preencher os campos
    pyautogui.write(str(codigo))
    pyautogui.press("tab")
    pyautogui.write(str(marca))
    pyautogui.press("tab")
    pyautogui.write(str(tipo))
    pyautogui.press("tab")
    pyautogui.write(str(categoria))
    pyautogui.press("tab")
    pyautogui.write(str(preco))
    pyautogui.press("tab")
    pyautogui.write(str(custo))
    pyautogui.press("tab")
    pyautogui.write(str(obs))

    # Selecionar o botao enviar e enter
    pyautogui.press("tab")
    pyautogui.press("enter")

    pyautogui.scroll(500000)



# Passo 5: Repetir o cadastro para todos os produtos
