var users = Array();
users[0] = {login:"admin", senha:"admin", CPF:'', data:'1978-12-22', lembrete:'Cidade natal'};
users[1] = {login:"rafael.melo", senha:"12345", CPF:'18773103012', data:'1988-10-01', lembrete:'Cachorro'};
users[2] = {login:"maria.ribeiro", senha:"112233", CPF:'67873396746', data:'', lembrete:''};
 
$(document).ready(function(){
	$("#button").click(function(){
		login = $('#login').val();
		senhaatual = $('#senhaatual').val().trim();
		data = $('#datanascimento').val();
		cpf = $('#cpf').val().trim();
		novasenha = $('#senhanova').val().trim();
		confirmacao = $('#confirmasenha').val();
		lembrete = $('#lembrete').val().trim();

		loginValido = false;
		senhaValida = false;

		dataCadastrada = '';
		cpfCadastrado = '';
		lembreteCadastrado = '';
		for(i = 0; i < users.length; i++){					
			if (login == users[i].login){
				loginValido = true;
				if ($('#senhaatual').val() == users[i].senha){
					senhaValida = true;
				}
				dataCadastrada = users[i].data;
				cpfCadastrado = users[i].CPF;
				lembreteCadastrado = users[i].lembrete;
				break;
			}
		}

		if (loginValido == false){
			alert("1 - O login " + login + " inválido!");
			return;
		} 
		if (senhaValida == false){
			alert("1 - Senha inválida para o login");
			return;
		}
		
		if (isGreaterThanCurrentDate(data)){
			alert("1 - Data de Nascimento é maior ou igual a " + new Date());
			return;
		}
		if (dataCadastrada != '' && data != dataCadastrada){
			alert("1 - Data de Nascimento incorreta para o login " + login);
			return;
		}
		if (cpf == ''){
			alert("1 - CPF não foi informado");
			return;
		}
		if (!validaCPF(cpf)){
			alert("1 - Dígito verificador inválido");
			return;			
		}
		if (cpfCadastrado != '' && cpf != cpfCadastrado){
			alert("1 - CPF incorreto para o login " + login);
			return;			
		}

		cpfEmOutroUser = false;
		for(i = 0; i < users.length; i++){					
			cpfEmOutroUser = (cpf == users[i].CPF) && (login != users[i].login);
			if (cpfEmOutroUser){
				alert("1 - CPF já informado para outro usuario");
				return;
			}
		}

		if (lembrete == ''){
			alert("1 - CPF não foi informado");
			return;
		}
		if (lembreteCadastrado != '' && lembrete != lembreteCadastrado){
			alert("1 - Lembrete de senha incorreto para o login " + login);
			return;
		}

		if (novasenha == ''){
			alert("1 - CPF não foi informado");
			return;
		}
		if (!validarSenha(novasenha)){
			return;
		}
		if (novasenha != confirmacao){
			alert("1 - Confirmaçao da nova senha está diferente da nova senha.");
			return;	
		}

		alert('Alteração realizada com sucesso!');
		return;

	});
});

function isValidDate(valor){
	var date=valor;
	var ardt=new Array;
	var ExpReg=new RegExp("(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}");
	ardt=date.split("/");
	erro=false;
	if ( date.search(ExpReg)==-1){
		erro = true;
		}
	else if (((ardt[1]==4)||(ardt[1]==6)||(ardt[1]==9)||(ardt[1]==11))&&(ardt[0]>30))
		erro = true;
	else if ( ardt[1]==2) {
		if ((ardt[0]>28)&&((ardt[2]%4)!=0))
			erro = true;
		if ((ardt[0]>29)&&((ardt[2]%4)==0))
			erro = true;
	}
	if (erro) {
		return false;
	}
	return true;
}

function isGreaterThanCurrentDate(date)
{
    var matches = /^(\d{2})[-\/](\d{2})[-\/](\d{4})$/.exec(date);
    if (matches == null) return false;
    var d = matches[1];
    var m = matches[2] - 1;
    var y = matches[3];
    var composedDate = new Date(y, m, d);
    return composedDate > new Date();
}

function validaCPF(cpf){
    var numeros, digitos, soma, i, resultado, digitos_iguais;
    digitos_iguais = 1;
    if (cpf.length < 11)
          return false;
    for (i = 0; i < cpf.length - 1; i++)
          if (cpf.charAt(i) != cpf.charAt(i + 1))
                {
                digitos_iguais = 0;
                break;
                }
    if (!digitos_iguais) {
          numeros = cpf.substring(0,9);
          digitos = cpf.substring(9);
          soma = 0;
          for (i = 10; i > 1; i--)
                soma += numeros.charAt(10 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(0))
                return false;
          numeros = cpf.substring(0,10);
          soma = 0;
          for (i = 11; i > 1; i--)
                soma += numeros.charAt(11 - i) * i;
          resultado = soma % 11 < 2 ? 0 : 11 - soma % 11;
          if (resultado != digitos.charAt(1))
                return false;
          return true;
          }
    else
        return false;
}

function validarSenha(senha){
	if (senha.length < 4){
		alert('Senha deve ter pelo menos 4 caraceres. Informe outra.');
		return false;
	}
	return true;
}
