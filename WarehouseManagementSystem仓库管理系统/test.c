#include<stdio.h>
#include<string.h>
#include<stdlib.h>

typedef struct Goods
{
	char name[20];
	float price;
	int number;
	char type[20];
	struct Goods *next;
}goods,*pgoods;

pgoods read(void);//��������
pgoods add(char strtype[]);//���ӻ�������
int judgetype(pgoods head,char strtype[]);//�ж������Ƿ����
pgoods addgoods(char strname[],float price,int number,char strtype[]);//�����»���
int judgename(pgoods head,char strname[],char strtype[]);//�жϻ����Ƿ��Ѿ�����
void goodplus(pgoods head,char strname[],int delta);//���
void goodreduce(pgoods head,char strname[],int delta);//����
void del(pgoods head,char strtype[]);//ɾ��������
void delname(pgoods head,char strname[]);//ɾ��������
void outputtype(pgoods head);//����Ļ��������б�
int count(char strtype[]);//ͳ�Ƹ������µĻ�������
void stockoutput(pgoods head,char strgoods[]);//��������ʾ
void searchname(pgoods head,char strname[]);//ȫ������������
void delempty(pgoods head);//�˳�����ǰɾ�����������в�������������
void write(pgoods head);//����д���ļ�
void destroy(pgoods head);//�����ڴ�

int main()
{
	FILE *fp;
	char ch,chname;
	char strtype[20]="empty";
	char strname[20]="EMPTY";
	int temp1;
	int delta=0;
	float price=0;
	int number=0;
	fp=fopen("a.txt","a+");
	if(fp==NULL)
	{
		printf("��������ʧ�ܣ�����ͬ��Ŀ¼�½���a.txt�ı��ļ���\n");
		exit(0);
	}

	printf("Tips:\t1��Ӣ�������������16����ĸ���ڣ�\n");
    printf("\t   ��������������� 8���������ڣ�\n");
	printf("    \t2����������Ҫǿ���˳�����\n\n����ָ������:\n");
	while(1)
	{
		pgoods head=NULL;
		printf("\t***********************************************\n");
		printf("\t*********************ִ�в˵�******************\n");
		printf("\tA:��ʾ���������б�;\t");
		printf("\tB:���ӻ�������;    \n");
		printf("\tC:ɾ����������;    \t");
		printf("\tD:�������;        \n");
		printf("\tE:�������;        \t");
		printf("\tF:�����ʾ;        \n");
		printf("\tG:ɾ������;        \t");
		printf("\tH:����ȫ������;    \n");
		printf("\tI:����             \t");
		printf("\tJ:�˳�!            \n");    //�˳�����������������ݣ���˽�������Ҫǿ���˳���
		printf("\t***********************************************\n\n");
		
		printf("����ִ��:");
		scanf("%c",&ch);
		fflush(stdin);
		if(ch=='A')
		{
			printf("\n");
			head=read();
			outputtype(head);
			destroy(head);
		}
		if(ch=='B')
		{
			printf("\n�������������ӵ�������:");
			scanf("%s",strtype);
			fflush(stdin);
			head=read();
			temp1=judgetype(head,strtype);
            if(temp1==1) 
			{
				head=add(strtype);
				write(head);
				destroy(head);
				printf("  ��ӳɹ�!\n\n");
			}
			else
			{
				printf("  �������Ѵ��ڣ�\n\n");
			}
		}
		if(ch=='C')
		{
			printf("\n����������ɾ����������:");
			gets(strtype);
			head=read();
			del(head,strtype);
			write(head);
			destroy(head);
		}
		if(ch=='D')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("�������������Ļ�����������:");
			scanf("%s",strtype);
			fflush(stdin);
			temp1=judgetype(head,strtype);
			if(temp1==1)
			{
				printf("  �������Ļ����������Ͳ�����!\n\n");
			}
			else
			{
			    stockoutput(head,strtype);
				printf("�������������Ļ�����:");
				gets(strname);
				temp1=judgename(head,strname,strtype);
				if(temp1 == -1) 
				{
					printf("\n  �������������(������):");
					scanf("%d",&delta);
					fflush(stdin);
					head=read();
					goodplus(head,strname,delta);
					write(head);
					printf("\n  ���ɹ���\n\n");
				}
				else if(temp1==-2)
				{
					printf("\n  �û�����ڵ��������ڴ����ͣ������²�����\n\n");
				}
				else
				{
					printf("\n  �û��ﲻ���ڣ��Ƿ�������(Y/N):");
					scanf("%c",&chname);
					fflush(stdin);
					
					if(chname=='Y'||chname=='y')
					{
						printf("\n  ��������Ʒ�۸�:");
						scanf("%f",&price);
						fflush(stdin);
						printf("\n  �������������:");
						scanf("%d",&number);
						fflush(stdin);
						head=addgoods(strname,price,number,strtype);
						write(head);
					}
					else
					{
						printf("\n  �����˳�����������\n\n");
					}
				}
			}
			destroy(head);
		}
		if(ch=='E')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("\n�������������������������:");
			scanf("%s",strtype);
			fflush(stdin);
			temp1=judgetype(head,strtype);
			if(temp1==1)
			{
				printf("  �������Ļ����������Ͳ����ڣ�\n\n");
			}
			else
			{
				stockoutput(head,strtype);
				printf("�������������Ļ�����:");
				gets(strname);
				temp1=judgename(head,strname,strtype);
				if(temp1==-1)
				{
					printf("\n�������������(������):");
					scanf("%d",&delta);
					fflush(stdin);
					goodreduce(head,strname,delta);
					write(head);
					destroy(head);
				}
				else if(temp1==-2)
				{
					printf("\n  �û�����ڵ��������ڴ����ͣ������²�����\n\n");
				}
				else
				{
					printf("\n  �û��ﲻ���ڣ��޷�ִ�г��������\n  ���������˵���\n\n");
				}
			}
		}
		if(ch=='F')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("����������鿴�Ļ�������:");
			scanf("%s",strtype);
			fflush(stdin);
			stockoutput(head,strtype);
			destroy(head);
		}
		if(ch=='G')
		{
			printf("\n");
			head=read();
			outputtype(head);
			printf("����ɾ���Ļ�����������:");
			scanf("%s",strtype);
			fflush(stdin);
			stockoutput(head,strtype);
			printf("\n����������ɾ���Ļ�����:");
			gets(strname);
			delname(head,strname);
			write(head);
			destroy(head);
		}
		if(ch=='H')
		{
			head=read();
			printf("\n���������������Ļ�����(��������������):");
			gets(strname);
			searchname(head,strname);
			destroy(head);
		}
		if(ch=='I')
		{
			system("cls");
		}
		if(ch=='J')
		{
			head=read();
			delempty(head);
			write(head);
 			destroy(head);
			printf("\n\t***************�ɹ��˳�!***************\n\n");
			exit(0);
		}
		if(ch!='A'&&ch!='B'&&ch!='C'&&ch!='D'&&ch!='E'&&ch!='F'&&ch!='G'&&ch!='H'&&ch!='I'&&ch!='j')
		{
			printf("\n �Ƿ�������\n\n");
		}
	}
	printf("***************************************\n");	
}
pgoods read(void)
{
	pgoods head,p,s;
	char str[20]="end";
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
    fclose(fpin);
	return head;
}

pgoods add(char strtype[])
{
	char strname[20]="NULL";
	char str[20]="end";
	pgoods head,p,s;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
	s=(pgoods)malloc(sizeof(goods));
	strcpy(s->name,strname);
	s->price=-1;
	s->number=0;
	strcpy(s->type,strtype);
	s->next=p->next;
	p->next=s;
	p=s;
    fclose(fpin);
	return head;
}

int judgetype(pgoods head,char strtype[])
{
	pgoods p=head->next;
	int temp=1;
	while(p!=NULL)
	{
		if(p->price<0&&strcmp(p->type,strtype)==0)
		{
			temp=-1;
		}
		p=p->next;
	}
	printf("\n");
	return temp;
}


void del(pgoods head,char strtype[])
{
	char str[20]="NULL";
	pgoods q=head,p=head->next;
	while((strcmp(p->name,str)!=0||strcmp(p->type,strtype)!=0)&&p->next!=NULL)
	{
		q=p;
		p=p->next;
	}
	if(p->price>-1)
	{
		printf("\n  ����ɾ���Ļ������Ͳ���ϵͳ��!\n\n");
	}
	else if((p->number=count(p->type))>0)
	{
		printf("\n  �������´��ڻ��ɾ����������ֹ��\n\n");
	}
	else
	{
		q->next=p->next;
		free(p);
		printf("\n  ɾ���ɹ�!\n\n");
	}
}

void delname(pgoods head,char strname[])
{
	char str[20]="NULL";
	pgoods q=head,p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		q=p;
		p=p->next;
	}
	if(strcmp(p->name,strname)!=0)
	{
		printf("\n  ����ɾ���Ļ��ﲻ��ϵͳ��!\n\n");
	}
	else if(p->number>0)
	{
		printf("\n  �û���������Ϊ�㣬ɾ����������ֹ��\n\n");
	}
	else
	{
		q->next=p->next;
		free(p);
		printf("\n  ɾ���ɹ�!\n\n");
	}
}

void outputtype(pgoods head)
{
	pgoods p=head->next;
	int n=1;
	int i=0;
	char str1[20]="end";
	char str2[20]="NULL";
	printf("\tORDER\t\tTYPE\t\tNUMBER\n");
	while(p!=NULL)
	{
		if(strcmp(p->name,str1)!=0&&strcmp(p->name,str2)==0)
		{
			p->number=count(p->type);
			printf("\t  %d\t\t%s",n++,p->type);
			for(i=0;i<16-(int)strlen(p->type);i++)
			{
				printf(" ");
			}
			printf("%d\n",p->number);
		}
		p=p->next;
	}
	printf("\n");
}

int count(char strtype[])
{
	pgoods head,p,s;
	char str[20]="end";
	int n=-1;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		if(strcmp(s->type,strtype)==0)
		{
			n++;
		}
		s->next=p->next;
		p->next=s;
		p=s;
	}
    fclose(fpin);
	return n;
}

void stockoutput(pgoods head,char strgoods[])
{
	pgoods p=head->next;
	int n=1;
	int i=0;
	char str1[20]="end";
	char str2[20]="NULL";
	printf("\n\tORDER\t\tNAME\t\tPRICE\t\tNUMBER\t\tTYPE\n");
	while(p!=NULL)
	{
		if(strcmp(p->name,str1)!=0&&strcmp(p->name,str2)!=0&&strcmp(p->type,strgoods)==0)
		{
			printf("\t  %d\t\t%s",n++,p->name);
			for(i=0;i<16-(int)strlen(p->name);i++)
			{
				printf(" ");
			}
			printf("%.2f\t\t%d\t\t%s\n",p->price,p->number,p->type);
		}
		p=p->next;
	}	
	printf("\n");
}

int judgename(pgoods head,char strname[],char strtype[])
{
	pgoods p=head->next;
	int temp=1;
	while(p!=NULL)
	{
		if(p->price>=0&&strcmp(p->name,strname)==0&&strcmp(p->type,strtype)==0)
		{
			temp=-1;
		}
		if(p->price>=0&&strcmp(p->name,strname)==0&&strcmp(p->type,strtype)!=0)
		{
			temp=-2;
		}
		p=p->next;
	}
	return temp;
}

void goodplus(pgoods head,char strname[],int delta)
{
	pgoods p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		p=p->next;
	}
	if(strcmp(p->name,strname)==0)
	{
		p->number+=delta;
	}
}

pgoods addgoods(char strname[],float price,int number,char strtype[])
{
	char str[20]="end";
	pgoods head,p,s;
	FILE *fpin;
	head=p=(pgoods)malloc(sizeof(goods)); 
	head->next=NULL;
	fpin=fopen("a.txt","r+");
	while(!feof(fpin))
	{
		s=(pgoods)malloc(sizeof(goods));
		strcpy(s->name,str);
		s->price=0;
		s->number=0;
		strcpy(s->type,str);
		fscanf(fpin,"%s%f%d%s",&s->name,&s->price,&s->number,&s->type);
		s->next=p->next;
		p->next=s;
		p=s;
	}
	s=(pgoods)malloc(sizeof(goods));
	strcpy(s->name,strname);
	s->price=price;
	s->number=number;
	
	strcpy(s->type,strtype);
	
	s->next=p->next;
	p->next=s;
	p=s;
	printf("\n  ���������ɹ���\n\n");
    fclose(fpin);
	return head;
}

void goodreduce(pgoods head,char strname[],int delta)
{
	pgoods p=head->next;
	while(strcmp(p->name,strname)!=0&&p->next!=NULL)
	{
		p=p->next;
	}
	if(strcmp(p->name,strname)==0)
	{
		if(delta>p->number)
		{
			printf("\n  ��治�㣬�������ʧ�ܣ�\n\n");
		}
		else
		{
			p->number-=delta;
	    	printf("\n  ����ɹ���\n\n");
		}
	}
}

void searchname(pgoods head,char strname[])
{
	pgoods p=head->next;
	int i=0;
	int flag=-1;
	char str[20]="end";
	if(strcmp(str,strname)==0)
	{
		flag=-1;
	}
	else
	{
		while(p!=NULL)
		{
			if(p->price>=0&&strcmp(p->name,strname)==0)
			{
				printf("\n\tNAME\t\tPRICE\t\tNUMBER\t\tTYPE\n");
				printf("\t%s",p->name);
				for(i=0;i<16-(int)strlen(p->name);i++)
				{
					printf(" ");
				}
				printf("%.2f\t\t%d\t\t%s\n",p->price,p->number,p->type);
				printf("\n\n");
				flag=1;
			}
			p=p->next;
		}
	}
	if(flag!=1)
	{
		printf("\n  �������Ļ��ﲻ��ϵͳ�ڣ�\n\n");
	}
}

void delempty(pgoods head)
{
	char str[20]="end";
	pgoods q=head,p=head->next;
	while(p->next!=NULL)
	{
		q=head;p=head->next;
		while(strcmp(p->name,str)!=0&&p->next!=NULL)
		{
			q=p;
			p=p->next;
		}
		if(strcmp(p->name,str)==0)
		{
			q->next=p->next;
			free(p);
		}
	}

}

void write(pgoods head)
{
	FILE *fpout;
	pgoods p=head->next;
	fpout=fopen("a.txt","w");
	while(p!=NULL)
	{
		fprintf(fpout,"%s\t%.2f\t%d\t%s\n",p->name,p->price,p->number,p->type);
		p=p->next;
	}
	fclose(fpout);
}

void destroy(pgoods head)
{
	pgoods p,q=head;
	while(q!=NULL)
	{
		p=q;
		q=q->next;
		free(p);
	}
}