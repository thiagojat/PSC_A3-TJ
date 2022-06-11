package pAdcionais;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class FuncoesAdicionais {
	
	public boolean verificaCPF(String cpf) {
		return true;
	}
//		String[] aCpf = cpf.split("\\B");
//
//		ArrayList<Integer> lCpf = new ArrayList<>();
//		for (String s : aCpf) {
//            lCpf.add(Integer.valueOf(s));
//        }		
//		if(lCpf.size()!= 11) {
//			JOptionPane.showMessageDialog(null, "Insira um CPF válido","Erro", JOptionPane.ERROR_MESSAGE);
//			return false;
//		}else {
//			int digV2 = lCpf.remove(lCpf.size()-1);
//			int digV1 = lCpf.remove(lCpf.size()-1);
//			
//			int soma1 = 0;
//			for (int i = 0; i < lCpf.size(); i++) {
//				int cur = lCpf.get(i);
//				soma1 += (cur*(i+1));
//			}
//			int cV1 = soma1%11; 
//			if(cV1 == 10) cV1 = 0;
//			if(digV1 != cV1){
//				JOptionPane.showMessageDialog(null, "Insira um CPF válido","Erro", JOptionPane.ERROR_MESSAGE);
//				System.out.println("Nao foi possivel verificar o primeiro digito. O primeiro digito calculado foi" + cV1);
//				return false;
//			}
//			lCpf.add(cV1);
//			int soma2 = 0;
//			int size = lCpf.size();
//			for(int i = 0; i < size; i++) {
//				soma2 += (lCpf.get(i)*(i));
//			}
//			int cV2 = soma2%11;
//			if(digV2 == cV2) {
//				return true;
//			}
//			else {
//				System.out.println("Nao foi possivel verificar o segundo digito. O segundo digito calculado foi" + cV2);
//				JOptionPane.showMessageDialog(null, "Insira um CPF válido","Erro", JOptionPane.ERROR_MESSAGE);
//				return false;
//			}
//		}
//	}
}
