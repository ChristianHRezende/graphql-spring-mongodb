package br.com.chrezende.graphqlex.fetcher;

import graphql.schema.DataFetchingEnvironment;

public interface DataFetcher<T>  {
	T get(DataFetchingEnvironment dataFetchingEnvironment) throws Exception;
}
